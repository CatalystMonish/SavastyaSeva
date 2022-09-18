package com.catalystmedia.swaystyaadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_bed.*

class BedActivity : AppCompatActivity() {


    var bedICU:Int = 0
    var bedICCU:Int = 0
    var bedGeneral:Int = 0
    var bedEmergency:Int = 0




    var vacant: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bed)

        var hospital = intent.getStringExtra("hospital")

        getICU(hospital)
        getICCU(hospital)
        getEmergency(hospital)
        getGeneral(hospital)
        getTotal(hospital)











    }

    private fun getICU(hospital: String?) {
        FirebaseDatabase.getInstance().reference.child("Beds/$hospital/ICU").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              if(snapshot.exists()) {
                  getTotal(hospital)
                  main_beds.visibility = View.VISIBLE
                  var bedAvail = snapshot.value.toString().toInt()

                  bedICU = bedAvail
                  getTotal(hospital)

                  Log.e("BedAvail",bedAvail.toString())

                  when (bedAvail) {
                      4-4 -> {
                          icu_1.setImageResource(R.drawable.ic_bed_empty)
                          icu_2.setImageResource(R.drawable.ic_bed_empty)
                          icu_3.setImageResource(R.drawable.ic_bed_empty)
                          icu_4.setImageResource(R.drawable.ic_bed_empty)


                      }
                      4-3 -> {
                          icu_1.setImageResource(R.drawable.ic_bed_empty)
                          icu_2.setImageResource(R.drawable.ic_bed_empty)
                          icu_3.setImageResource(R.drawable.ic_bed_empty)
                          icu_4.setImageResource(R.drawable.ic_bed_green)


                      }
                      4-2 -> {
                          icu_1.setImageResource(R.drawable.ic_bed_empty)
                          icu_2.setImageResource(R.drawable.ic_bed_empty)
                          icu_3.setImageResource(R.drawable.ic_bed_green)
                          icu_4.setImageResource(R.drawable.ic_bed_green)


                      }
                      4-1 -> {
                          icu_1.setImageResource(R.drawable.ic_bed_empty)
                          icu_2.setImageResource(R.drawable.ic_bed_green)
                          icu_3.setImageResource(R.drawable.ic_bed_green)
                          icu_4.setImageResource(R.drawable.ic_bed_green)


                      }
                      4-0 -> {
                          icu_1.setImageResource(R.drawable.ic_bed_green)
                          icu_2.setImageResource(R.drawable.ic_bed_green)
                          icu_3.setImageResource(R.drawable.ic_bed_green)
                          icu_4.setImageResource(R.drawable.ic_bed_green)


                      }
                  }
              }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


    private fun getICCU(hospital: String?) {
        FirebaseDatabase.getInstance().reference.child("Beds/$hospital/ICCU").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    getTotal(hospital)
                    main_beds.visibility = View.VISIBLE

                    var bedAvail = snapshot.value.toString().toInt()

                    bedICCU = bedAvail
                    getTotal(hospital)

                    Log.e("BedAvail",bedAvail.toString())

                    when (bedAvail) {
                        4-4 -> {
                            iccu_1.setImageResource(R.drawable.ic_bed_empty)
                            iccu_2.setImageResource(R.drawable.ic_bed_empty)
                            iccu_3.setImageResource(R.drawable.ic_bed_empty)
                            iccu_4.setImageResource(R.drawable.ic_bed_empty)


                        }
                        4-3 -> {
                            iccu_1.setImageResource(R.drawable.ic_bed_empty)
                            iccu_2.setImageResource(R.drawable.ic_bed_empty)
                            iccu_3.setImageResource(R.drawable.ic_bed_empty)
                            iccu_4.setImageResource(R.drawable.ic_bed_orange)


                        }
                        4-2 -> {
                            iccu_1.setImageResource(R.drawable.ic_bed_empty)
                            iccu_2.setImageResource(R.drawable.ic_bed_empty)
                            iccu_3.setImageResource(R.drawable.ic_bed_orange)
                            iccu_4.setImageResource(R.drawable.ic_bed_orange)


                        }
                        4-1 -> {
                            iccu_1.setImageResource(R.drawable.ic_bed_empty)
                            iccu_2.setImageResource(R.drawable.ic_bed_orange)
                            iccu_3.setImageResource(R.drawable.ic_bed_orange)
                            iccu_4.setImageResource(R.drawable.ic_bed_orange)


                        }
                        4-0 -> {
                            iccu_1.setImageResource(R.drawable.ic_bed_orange)
                            iccu_2.setImageResource(R.drawable.ic_bed_orange)
                            iccu_3.setImageResource(R.drawable.ic_bed_orange)
                            iccu_4.setImageResource(R.drawable.ic_bed_orange)


                        }
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun getEmergency(hospital: String?) {
        FirebaseDatabase.getInstance().reference.child("Beds/$hospital/EMERGENCY").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {

                    main_beds.visibility = View.VISIBLE

                    var bedAvail = snapshot.value.toString().toInt()

                    bedEmergency = bedAvail
                    getTotal(hospital)

                    Log.e("BedAvail",bedAvail.toString())

                    when (bedAvail) {
                        4-4 -> {
                            em_1.setImageResource(R.drawable.ic_bed_empty)
                            em_2.setImageResource(R.drawable.ic_bed_empty)
                            em_3.setImageResource(R.drawable.ic_bed_empty)
                            em_4.setImageResource(R.drawable.ic_bed_empty)


                        }
                        4-3 -> {
                            em_1.setImageResource(R.drawable.ic_bed_empty)
                            em_2.setImageResource(R.drawable.ic_bed_empty)
                            em_3.setImageResource(R.drawable.ic_bed_empty)
                            em_4.setImageResource(R.drawable.ic_bed_red)


                        }
                        4-2 -> {
                            em_1.setImageResource(R.drawable.ic_bed_empty)
                            em_2.setImageResource(R.drawable.ic_bed_empty)
                            em_3.setImageResource(R.drawable.ic_bed_red)
                            em_4.setImageResource(R.drawable.ic_bed_red)


                        }
                        4-1 -> {
                            em_1.setImageResource(R.drawable.ic_bed_empty)
                            em_2.setImageResource(R.drawable.ic_bed_red)
                            em_3.setImageResource(R.drawable.ic_bed_red)
                            em_4.setImageResource(R.drawable.ic_bed_red)


                        }
                        4-0 -> {
                            em_1.setImageResource(R.drawable.ic_bed_red)
                            em_2.setImageResource(R.drawable.ic_bed_red)
                            em_3.setImageResource(R.drawable.ic_bed_red)
                            em_4.setImageResource(R.drawable.ic_bed_red)


                        }
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


    private fun getGeneral(hospital: String?) {
        FirebaseDatabase.getInstance().reference.child("Beds/$hospital/GENERAL").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {

                    main_beds.visibility = View.VISIBLE

                    var bedAvail = snapshot.value.toString().toInt()

                    bedGeneral = bedAvail
                    getTotal(hospital)


                    Log.e("BedAvail",bedAvail.toString())

                    when (bedAvail) {
                        4-4 -> {
                            gen_1.setImageResource(R.drawable.ic_bed_empty)
                            gen_2.setImageResource(R.drawable.ic_bed_empty)
                            gen_3.setImageResource(R.drawable.ic_bed_empty)
                            gen_4.setImageResource(R.drawable.ic_bed_empty)


                        }
                        4-3 -> {
                            gen_1.setImageResource(R.drawable.ic_bed_empty)
                            gen_2.setImageResource(R.drawable.ic_bed_empty)
                            gen_3.setImageResource(R.drawable.ic_bed_empty)
                            gen_4.setImageResource(R.drawable.ic_bed_blue)


                        }
                        4-2 -> {
                            gen_1.setImageResource(R.drawable.ic_bed_empty)
                            gen_2.setImageResource(R.drawable.ic_bed_empty)
                            gen_3.setImageResource(R.drawable.ic_bed_blue)
                            gen_4.setImageResource(R.drawable.ic_bed_blue)


                        }
                        4-1 -> {
                            gen_1.setImageResource(R.drawable.ic_bed_empty)
                            gen_2.setImageResource(R.drawable.ic_bed_blue)
                            gen_3.setImageResource(R.drawable.ic_bed_blue)
                            gen_4.setImageResource(R.drawable.ic_bed_blue)


                        }
                        4-0 -> {
                            gen_1.setImageResource(R.drawable.ic_bed_blue)
                            gen_2.setImageResource(R.drawable.ic_bed_blue)
                            gen_3.setImageResource(R.drawable.ic_bed_blue)
                            gen_4.setImageResource(R.drawable.ic_bed_blue)


                        }
                    }
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    private  fun getTotal(hospital: String?) {
        var totalBedsOccupied = bedEmergency + bedICU + bedICCU + bedGeneral
       tv_occupied.text = totalBedsOccupied.toString()

        var vacantBeds = 16 - totalBedsOccupied
        tv_vacant.text = vacantBeds.toString()

    }
}