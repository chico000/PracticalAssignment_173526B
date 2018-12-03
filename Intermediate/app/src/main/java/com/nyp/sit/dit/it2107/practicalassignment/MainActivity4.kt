package com.nyp.sit.dit.it2107.practicalassignment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val movie = applicationContext as Movie
        movieName.setText( movie.getTitle1())
        movieDesc.setText(movie.getDesc1())
        if (movie.getLang1() == "English"){
            englishLang.isChecked = true

        }else if(movie.getLang1() == "Chinese"){
            chineseLang.isChecked = true
        }else if (movie.getLang1() == "Malay"){
            malayLang.isChecked = true
        }else {
            tamilLang.isChecked = true
        }
        releaseDate.setText(movie.getDate())
        if(movie.getSuit1() != ""){
            notSuitable.isChecked = true
        }
        if(movie.getLangUsed1() != "")
            languageUsed.isChecked = true
        if(movie.getViolenceSuit1()!="")
            violence.isChecked=true
    }
}
