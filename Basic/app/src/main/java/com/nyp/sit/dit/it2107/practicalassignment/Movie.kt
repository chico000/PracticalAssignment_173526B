package com.nyp.sit.dit.it2107.practicalassignment

import android.widget.EditText
import com.nyp.sit.dit.it2107.practicalassignment.R.string.review
import java.io.Serializable

class Movie{
    var title: String=""
        get() = field
        set(value){
            field = value
        }

    var desc: String=""
        get() = field
        set(value){
            field = value
        }

    var langM:String=""
        get() = field
        set(value){
            field = value
        }

    var releaseDate:String =""
        get() = field
        set(value){
            field = value
        }

    var suit :String=""
        get() = field
        set(value){
            field = value
        }

    var review = ""
        get() = field
        set(value){
            field = value
        }




}
//fun main(args:Array<String>){
//    var movie = Movie()
//    movie.review="Gayyyyy"
//    println(movie.title)
//}
