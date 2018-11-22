package com.nyp.sit.dit.it2107.practicalassignment

import android.app.Application

class Movie: Application(){


    var title =""
    fun getTitle1():String{
        return title
    }
    fun setTitle1(title:String){
        this.title = title
    }
//    var desc: String=""
//    var langM:String=""
//
//    var releaseDate:String =""
//    var suit :String=""
//    var review : String ="Long press here to add your review"
//
//

    private var singleton: Movie? = null

    fun getInstance(): Movie? {
        return singleton
    }

    override fun onCreate() {
        super.onCreate()
        singleton = this
    }
}
