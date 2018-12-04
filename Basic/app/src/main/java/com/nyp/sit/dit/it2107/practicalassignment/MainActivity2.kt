package com.nyp.sit.dit.it2107.practicalassignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val movie = Movie("Venom","He Black","Chinese","13-02-2019" )
//        val intent = intent
        val titleVar = findViewById<TextView>(R.id.title)

        val overVar = findViewById<TextView>(R.id.overView)

        val dateVar = findViewById<TextView>(R.id.releaseView)

        val langVar = findViewById<TextView>(R.id.langView)

        val suitVar = findViewById<TextView>(R.id.suitable)
        titleVar.text = movie.title
        overVar.text = movie.desc
        dateVar.text = movie.releaseDate
        langVar.text =movie.langM
        suitVar.text = movie.suit
//        val intentStart = Intent(this@MainActivity2,MainActivity::class.java )
//        addMovieButton.setOnClickListener({
//            startActivity(intentStart)
//        })
//        val intentRate = Intent(this@MainActivity2,MainActivity3::class.java )
//        intentRate.putExtra("movieName1",titleVar.text.toString())
//        movieRate.setOnClickListener({
//            startActivity(intentRate)
//        })
    }
}