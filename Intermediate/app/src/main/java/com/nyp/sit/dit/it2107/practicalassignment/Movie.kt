package com.nyp.sit.dit.it2107.practicalassignment

import android.app.Application
class MovieEntity(title:String,desc:String,date:String,suit:String,lang:String,langUsed:String,violence:String){
    var title =title

    var desc: String=desc


    var langM:String=lang


    var releaseDate:String =date

    var suit :String=suit

    var review : String ="Long press here to add your review"


    var xingXing : Float = 0F

    var langUsed : String = langUsed

    var violenceSuit : String = violence


}
class Movie:Application(){



    var movieArray:ArrayList<MovieEntity>?=null
    fun addMovie(newMovieEntity: MovieEntity){
        if(movieArray==null){
            movieArray = arrayListOf<MovieEntity>()
        }
        movieArray?.add(newMovieEntity)
    }

    fun getMovie():ArrayList<MovieEntity>?{
        return movieArray
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
