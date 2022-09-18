package com.catalystmedia.swaystyaadmin.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.catalystmedia.swaystyaadmin.AddPatientActivity
import com.catalystmedia.swaystyaadmin.R
import io.github.g00fy2.quickie.QRResult
import io.github.g00fy2.quickie.ScanCustomCode
import io.github.g00fy2.quickie.ScanQRCode
import io.github.g00fy2.quickie.config.BarcodeFormat
import io.github.g00fy2.quickie.config.ScannerConfig
import kotlinx.android.synthetic.main.fragment_device.*

class DeviceFragment : Fragment() {

    var hospitalName:String = ""

    val scanCustomCode = registerForActivityResult(ScanCustomCode(), ::handleResult)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_device, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        hospitalName = activity?.intent?.extras?.get("hospital").toString()

        btn_start_scan.setOnClickListener {

            scanCustomCode.launch(null)
        }
    }

    fun handleResult(result: QRResult) {
        var strQRFUll =  result.toString()
        var strDrpStr = strQRFUll.drop(33)
        var strDrpEnd = strDrpStr.dropLast(2)

        var strFinal = strDrpEnd


        Toast.makeText(activity, result.toString(), Toast.LENGTH_LONG).show()
        Log.d("OutputQR", strFinal)

        val intent = Intent(activity, AddPatientActivity::class.java)
        intent.putExtra("bandID", strFinal)
        intent.putExtra("hospital", hospitalName.toString())
        startActivity(intent)






    }



}