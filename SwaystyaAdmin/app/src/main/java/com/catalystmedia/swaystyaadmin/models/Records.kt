package com.catalystmedia.swaystyaadmin.models

class Records {


        private var age:String = ""
        private var name:String = ""
        private var gender:String = ""
        private var contact:String = ""
        private var tagid: String = ""
        private var type: String = ""


        constructor()
        constructor(age: String, name: String, gender:String, contact:String, tagid:String, type:String)
        {
            this.age = age
            this.name = name
            this.gender = gender
            this.contact = contact
            this.tagid = tagid
            this.type = type

        }
        fun getage():String
        {
            return age
        }
        fun setage(age:String){
            this.age = age
        }
        fun getname():String
        {
            return name
        }
        fun setname(name:String){
            this.name = name
        }
        fun getgender():String
        {
        return gender
        }
        fun setgender(gender:String){
        this.gender = gender
        }

        fun getcontact():String
        {
            return contact
        }
        fun setcontact(contact: String){
            this.contact = contact
        }


    fun gettagid():String
    {
        return tagid
    }
    fun settagid(tagid: String){
        this.tagid = tagid
    }




    fun gettype():String
    {
        return type
    }
    fun settype(type: String){
        this.type = type
    }



}

