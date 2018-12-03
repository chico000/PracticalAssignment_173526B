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
    }
}
