package com.catalystmedia.swaystyaadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_essentials.*

class EssentialsActivity : AppCompatActivity() {



     var alc:Int    = 0
     var bp:Int   = 0
     var gau:Int   = 0
     var glo:Int   = 0
     var oxy:Int   = 0
     var sal:Int   = 0
     var syr:Int   = 0
     var ven:Int   = 0
     var whchr:Int   = 0








    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_essentials)



        getData("alch")
        getData("bp")
        getData("gau")
        getData("glo")
        getData("oxy")
        getData("sal")
        getData("syr")
        getData("ven")
        getData("whchr")














        add_1.setOnClickListener {


            var oldVal = 0


            FirebaseDatabase.getInstance().reference.child("Essentials").child("oxy")
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.exists()){

                            oldVal = snapshot.value.toString().toInt()

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })

            var newVal = oldVal + 1

            FirebaseDatabase.getInstance().reference.child("Essentials").child("oxy").setValue(newVal)
        }

        add_2.setOnClickListener {


            var oldVal = 0


            FirebaseDatabase.getInstance().reference.child("Essentials").child("ven")
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.exists()){

                            oldVal = snapshot.value.toString().toInt()

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })

            var newVal = oldVal + 1

            FirebaseDatabase.getInstance().reference.child("Essentials").child("ven").setValue(newVal)
        }

        add_3.setOnClickListener {


            var oldVal = 0


            FirebaseDatabase.getInstance().reference.child("Essentials").child("bp")
                .addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.exists()){

                            oldVal = snapshot.value.toString().toInt()

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })

            var newVal = oldVal + 1

            FirebaseDatabase.getInstance().reference.child("Essentials").child("bp").setValue(newVal)
        }



    }

    private fun getData(s: String) {


        FirebaseDatabase.getInstance().reference.child("Essentials").child(s).addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){

                    if(s=="alch"){
                        tv_8.text = snapshot.value.toString()
                    }
                    else if(s=="bp"){
                        tv_3.text = snapshot.value.toString()
                    }
                    else if(s=="gau"){
                        tv_5.text = snapshot.value.toString()
                    }
                    else if(s=="glo"){
                        tv_9.text = snapshot.value.toString()
                    }
                    else if(s=="oxy"){
                        tv_1.text = snapshot.value.toString()
                    }
                    else if(s=="sal"){
                        tv_6.text = snapshot.value.toString()
                    }
                    else if(s=="syr"){
                        tv_4.text = snapshot.value.toString()
                    }
                    else if(s=="ven"){
                        tv_2.text = snapshot.value.toString()
                    }
                    else if(s=="whchr"){
                        tv_7.text = snapshot.value.toString()
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}