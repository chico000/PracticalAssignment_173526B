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
    var desc: String=""
    fun getDesc1():String{
        return desc
    }
    fun setDesc1(desc:String){
        this.desc = desc
    }
    var langM:String=""

    fun getLang1():String{
        return langM
    }
    fun setLang1(lang:String){
        this.langM = lang
    }
    var releaseDate:String =""
    fun getDate():String{
        return releaseDate
    }
    fun setDate(date:String){
        this.releaseDate = date
    }
    var suit :String=""
    fun getSuit1():String{
        return suit
    }
    fun setSuit1(suit:String){
        this.suit = suit
    }
    var review : String ="Long press here to add your review"
    fun getReview1():String{
        return review
    }
    fun setReview1(review:String){
        this.review = review
    }

    var xingXing : Float = 0F
    fun getStar():Float{
        return xingXing
    }
    fun setStar(star:Float){
        this.xingXing = star
    }

    private var singleton: Movie? = null

    fun getInstance(): Movie? {
        return singleton
    }

    override fun onCreate() {
        super.onCreate()
        singleton = this
    }
}
