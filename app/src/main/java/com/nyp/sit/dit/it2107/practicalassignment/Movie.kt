package com.nyp.sit.dit.it2107.practicalassignment

import android.widget.EditText

class Movie (title:String, description:String, languageM:String, releaseD:String, suitable:String = "Yes"){
    var title: String
    var desc: String
    var langM:String
    var releaseDate:String
    var suit :String

    init{
        this.title = title
        this.desc = description
        this.langM = languageM
        this.releaseDate=releaseD
        this.suit = suitable

    }

}