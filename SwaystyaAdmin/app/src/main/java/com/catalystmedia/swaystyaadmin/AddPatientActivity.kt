package com.catalystmedia.swaystyaadmin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_add_patient.*


class AddPatientActivity : AppCompatActivity() {

    lateinit var selectedGender: String
    lateinit var selectedType: String
    var hospitalName:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_patient)
        selectedGender = "Male"
        selectedType = "GENERAL"
        var globalBand = intent.getStringExtra("bandID").toString()
        hospitalName = intent.extras?.get("hospital").toString()
        tv_bandID.text = "ID:$globalBand"
        spinner.setItems("Male", "Female", "Other");
        spinner_bed.setItems("GENERAL", "ICU", "ICCU", "EMERGENCY");

        spinner.setOnItemSelectedListener { view, position, id, item ->

            selectedGender = item.toString()
        }

        spinner_bed.setOnItemSelectedListener { view, position, id, item ->

           selectedType = item.toString()
        }





        btn_add_patient_new_scan.setOnClickListener {
            var nameNew = et_name_new.text.toString()
            var contactNew = et_contact_new.text.toString()
            var ageNew = et_age_new.text.toString()
            var genderNew = selectedGender.toString()



            uploadData(nameNew, contactNew, ageNew, genderNew, globalBand)
        }


    }

    private fun uploadData(
        nameNew: String,
        contactNew: String,
        ageNew: String,
        genderNew: String,
        globalBand: String
    ) {
        val usersRef: DatabaseReference =
            FirebaseDatabase.getInstance().reference.child("Patients/Scanned/$hospitalName")
        val userMap = HashMap<String, Any>()
        userMap["name"] = nameNew.toString()
        userMap["contact"] = contactNew.toString()
        userMap["age"] = ageNew.toString()
        userMap["gender"] = genderNew.toString()
        userMap["tagid"] = globalBand.toString()
        userMap["type"] = selectedType.toString()
        usersRef.child(globalBand).setValue(userMap)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    occupyBed()

                }
            }
    }

    private fun occupyBed() {
       FirebaseDatabase.getInstance().reference.child("Beds/$hospitalName").child(selectedType).addListenerForSingleValueEvent(object :ValueEventListener{
           override fun onDataChange(snapshot: DataSnapshot) {
               if(snapshot.exists()){

                   var previous = snapshot.value.toString().toInt()
                   changeValue(previous)

               }
           }

           override fun onCancelled(error: DatabaseError) {
               TODO("Not yet implemented")
           }
       })
    }

    private fun changeValue(previous: Int) {
        var newValue = previous + 1
        FirebaseDatabase.getInstance().reference.child("Beds/$hospitalName").child(selectedType).setValue(newValue).addOnCompleteListener { task->
            finish()
        }
    }
}