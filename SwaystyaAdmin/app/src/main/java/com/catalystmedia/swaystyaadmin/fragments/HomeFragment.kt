package com.catalystmedia.swaystyaadmin.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catalystmedia.swaystyaadmin.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    var hospitalName:String = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hospitalName = activity?.intent?.extras?.get("hospital").toString()
        tv_home_hospital_name.text = hospitalName.toString() + " Hospital"


        btn_bed_home.setOnClickListener {
            val intent = Intent(activity, BedActivity::class.java)
            intent.putExtra("hospital", hospitalName.toString())
            startActivity(intent)
        }

        btn_demo.setOnClickListener {
            val intent = Intent(activity, DemoActivity::class.java)
            startActivity(intent)
        }

        btn_essentials.setOnClickListener {
            val intent = Intent(activity, EssentialsActivity::class.java)
            startActivity(intent)
        }

        btn_appointments.setOnClickListener{
            val intent = Intent(activity, AppoitnmentActivity::class.java)
            startActivity(intent)
        }

        btn_records.setOnClickListener{
            val intent = Intent(activity, RecordsActivity::class.java)
            intent.putExtra("hospital", hospitalName.toString())
            startActivity(intent)
        }



    }




}