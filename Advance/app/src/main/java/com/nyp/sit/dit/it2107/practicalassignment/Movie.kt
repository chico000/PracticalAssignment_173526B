package com.nyp.sit.dit.it2107.practicalassignment

import android.app.Application
import java.util.*
class Mov(title: String,desc: String,lang: String,date: String,suit: String){

    var title :String=""

    var desc: String=""

    var langM:String=""


    var releaseDate:String =""

    var suit :String=""
   init {
       this.title=title
       this.desc=desc
       this.langM=lang
       this.releaseDate=date
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
}
class Movie:Application(){


    var movieArray:ArrayList<Mov>?=null

    fun getArray():ArrayList<Mov>?{
        return movieArray
    }
    fun addMovie(newMovie:Mov){
        movieArray!!.add(newMovie)
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
//fun main(args : Array<String>) {
//    val movie :Movie =
//
//    movie.setTitle1("hi")
//    movie.addMovie(movie)
//
//    println(movie.getArray())
//
//}