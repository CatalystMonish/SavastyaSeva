package com.catalystmedia.swaystyaadmin.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.catalystmedia.swaystyaadmin.R
import com.catalystmedia.swaystyaadmin.models.Records
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class RecordsAdapter(private var mContext: Context, private var mList: ArrayList<Records>):
    RecyclerView.Adapter<RecordsAdapter.ViewHolder>() {
        private var mCtx: Context? = null
        private var profileList: MutableList<Records>? = null
        private var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsAdapter.ViewHolder {
            return RecordsAdapter.ViewHolder(
                LayoutInflater.from(mContext).inflate(
                    R.layout.patient_recycler,
                    parent,
                    false
                )
            )
        }


        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: RecordsAdapter.ViewHolder, position: Int) {
            val item = mList[position]
            var hospitalName = (mContext as Activity).intent.getStringExtra("hospital")
            var fullName = item.getname()

            holder.patientName.text = fullName.toString()
            holder.patientEmail.text = item.getcontact()

            if(item.getgender() == "Male"){
                holder.gender.text = "M"
            }
            else if(item.getgender() == "Female"){
                holder.gender.text = "F"
            }
            else if(item.getgender() == "Other"){
                holder.gender.text = "O"
            }

            holder.patientPhone.text = "ID:" + item.gettagid()


            if(item.getgender().toString() == "Male"){
                holder.pfp.setImageResource(R.drawable.boy)
            }
            else if(item.getgender().toString() == "Female"){
                    holder.pfp.setImageResource(R.drawable.girl)
                }

            holder.discharge.visibility = View.VISIBLE

            holder.discharge.setOnClickListener{

                FirebaseDatabase.getInstance().reference.child("Patients/Scanned/$hospitalName").child(item.gettagid()).removeValue().addOnCompleteListener{ task ->

                }


                FirebaseDatabase.getInstance().reference.child("Beds/$hospitalName").child(item.gettype()).addListenerForSingleValueEvent(object :
                    ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if(snapshot.exists()){

                            var previous = snapshot.value.toString().toInt()
                            var newValue = previous - 1
                            FirebaseDatabase.getInstance().reference.child("Beds/$hospitalName").child(item.gettype()).setValue(newValue).addOnCompleteListener { task->
                                (mContext as Activity).finish()
                            }

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }
                })




            }




        }


        override fun getItemCount(): Int {
            return mList.size
        }



        class ViewHolder (@NonNull itemView: View): RecyclerView.ViewHolder(itemView)
        {
            var patientName: TextView = itemView.findViewById(R.id.tv_patient_name)
            var patientEmail: TextView = itemView.findViewById(R.id.tv_email)
            var patientPhone: TextView = itemView.findViewById(R.id.tv_contact)
            var gender: TextView = itemView.findViewById(R.id.tv_gender)
            var date: TextView = itemView.findViewById(R.id.tv_date)
            var pfp: ImageView = itemView.findViewById(R.id.iv_pfp)
            var discharge: Button = itemView.findViewById(R.id.btn_discharge)



        }



    }
