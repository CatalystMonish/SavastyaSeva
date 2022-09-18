package com.catalystmedia.swaystyaadmin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_demo.*

class DemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)



        fireInit()
    }

    private fun fireInit(){


        FirebaseDatabase.getInstance().reference.child("Modules/Hospitals/HospitalName/Emergency/38192723/patient").addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               if(snapshot.exists()){

                   if(snapshot.value == true){

                       iv_bed01.setImageResource(R.drawable.ic_bed_green)

                       iv_bed01_status.setImageResource(R.drawable.ic_status)

                   }

                   else if(snapshot.value == false){
                       iv_bed01.setImageResource(R.drawable.ic_bed_empty)

                       iv_bed01_status.setImageResource(R.drawable.ic_status_waiting)
                   }




               }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })



    }
}