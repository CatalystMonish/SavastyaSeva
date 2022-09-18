package com.catalystmedia.swaystyaadmin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.catalystmedia.swaystyaadmin.R
import com.catalystmedia.swaystyaadmin.models.Appointments
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AppointmentsAdapter(private var mContext: Context, private var mList: ArrayList<Appointments>):
    RecyclerView.Adapter<AppointmentsAdapter.ViewHolder>() {
        private var mCtx: Context? = null
        private var profileList: MutableList<Appointments>? = null
        private var firebaseUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentsAdapter.ViewHolder {
            return AppointmentsAdapter.ViewHolder(
                LayoutInflater.from(mContext).inflate(
                    R.layout.patient_recycler,
                    parent,
                    false
                )
            )
        }


        override fun onBindViewHolder(holder: AppointmentsAdapter.ViewHolder, position: Int) {
            val item = mList[position]
            var firstName = item.getfirstname()
            var lastName =  item.getlastname()
            var fullName = "$firstName $lastName"

            holder.patientName.text = fullName.toString()
            holder.patientEmail.text = item.getemail()
            holder.date.text = item.getdateofappointment()
            holder.gender.text = item.getgender()
            holder.patientPhone.text = item.getphonenumber()

            if(item.getgender().toString() == "Male"){
                holder.pfp.setImageResource(R.drawable.boy)
            }
            else if(item.getgender().toString() == "Female"){
                    holder.pfp.setImageResource(R.drawable.girl)
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



        }



    }
