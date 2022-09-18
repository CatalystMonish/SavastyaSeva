package com.catalystmedia.swaystyaadmin.models

class Appointments {


        private var dateofappointment:String = ""
        private var firstname:String = ""
        private var lastname:String = ""
        private var gender:String = ""
        private var email:String = ""
        private var phonenumber:String = ""


        constructor()
        constructor(dateofappointment: String, firstname: String, lastname:String)
        {
            this.dateofappointment = dateofappointment
            this.firstname = firstname
            this.lastname = lastname
            this.gender = gender
            this.email = email
            this.phonenumber = phonenumber

        }
        fun getdateofappointment():String
        {
            return dateofappointment
        }
        fun setdateofappointment(dateofappointment:String){
            this.dateofappointment = dateofappointment
        }
        fun getfirstname():String
        {
            return firstname
        }
        fun setfirstname(firstname:String){
            this.firstname = firstname
        }
        fun getlastname():String
        {
        return lastname
        }
        fun setlastname(lastname:String){
        this.lastname = lastname
        }
        fun getgender():String
        {
        return gender
        }
        fun setgender(gender:String){
        this.gender = gender
        }

        fun getemail():String
        {
            return email
        }
        fun setemail(email:String){
            this.email = email
        }

        fun getphonenumber():String
        {
            return phonenumber
        }
        fun setphonenumber(phonenumber:String){
            this.phonenumber = phonenumber
        }



}

