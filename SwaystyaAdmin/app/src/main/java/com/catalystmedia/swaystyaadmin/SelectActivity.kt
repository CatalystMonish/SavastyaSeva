package com.catalystmedia.swaystyaadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_select.*

class SelectActivity : AppCompatActivity() {



    lateinit var selectedHospital: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        selectedHospital = "Lotus"

        spinner_select.setItems("Lotus", "Ashlok", "Fortis");
        spinner_select.setOnItemSelectedListener { view, position, id, item ->

            selectedHospital = item.toString()
            btn_login_hospital.text = "Login as $selectedHospital"


            }


        btn_login_hospital.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            intent.putExtra("hospital", selectedHospital.toString())
            startActivity(intent)
        }





    }
}