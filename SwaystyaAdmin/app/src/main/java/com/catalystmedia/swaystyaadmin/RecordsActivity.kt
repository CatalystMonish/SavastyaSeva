package com.catalystmedia.swaystyaadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.catalystmedia.swaystyaadmin.adapters.AppointmentsAdapter
import com.catalystmedia.swaystyaadmin.adapters.RecordsAdapter
import com.catalystmedia.swaystyaadmin.models.Appointments
import com.catalystmedia.swaystyaadmin.models.Records
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RecordsActivity : AppCompatActivity() {

    private var recordsAdapter: RecordsAdapter? = null
    private var itemList: MutableList<Records>? = null
    private var firebaseUser: FirebaseUser? = null

    var hospitalName:String = ""





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)
        hospitalName = intent.extras?.get("hospital").toString()
        var recyclerView: RecyclerView? = null
        recyclerView = findViewById(R.id.rv_records)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        itemList = ArrayList()
        recordsAdapter = RecordsAdapter(this, itemList as ArrayList<Records>)
        recyclerView.adapter = recordsAdapter


        getData()
    }

    private fun getData() {
        val appointmentsRef = FirebaseDatabase.getInstance().reference.child("Patients/Scanned/$hospitalName")
        appointmentsRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    itemList!!.clear()
                    for (snapshot in dataSnapshot.children) {
                        val item = snapshot.getValue(Records::class.java)
                        itemList!!.add(item!!)
                    }
                    recordsAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}