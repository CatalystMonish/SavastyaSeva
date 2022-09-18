package com.catalystmedia.swaystyaadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.catalystmedia.swaystyaadmin.adapters.AppointmentsAdapter
import com.catalystmedia.swaystyaadmin.models.Appointments
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AppoitnmentActivity : AppCompatActivity() {

    private var appointmentsAdapter: AppointmentsAdapter? = null
    private var itemList: MutableList<Appointments>? = null
    private var firebaseUser: FirebaseUser? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appoitnment)

        var recyclerView: RecyclerView? = null
        recyclerView = findViewById(R.id.rv_appointments)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        itemList = ArrayList()
        appointmentsAdapter = AppointmentsAdapter(this, itemList as ArrayList<Appointments>)
        recyclerView.adapter = appointmentsAdapter


        getData()
    }

    private fun getData() {
        val appointmentsRef = FirebaseDatabase.getInstance().reference.child("Appointments")
        appointmentsRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    itemList!!.clear()
                    for (snapshot in dataSnapshot.children) {
                        val item = snapshot.getValue(Appointments::class.java)
                        itemList!!.add(item!!)
                    }
                    appointmentsAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}