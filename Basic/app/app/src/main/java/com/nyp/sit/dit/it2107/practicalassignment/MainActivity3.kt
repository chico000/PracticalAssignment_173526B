package com.nyp.sit.dit.it2107.practicalassignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val intent = intent
        val titleVar = findViewById<TextView>(R.id.reviewName)
        titleVar.text = intent.getStringExtra("movieName1")
        val intentStart = Intent(this@MainActivity3,MainActivity::class.java )
        addMovieButton1.setOnClickListener({
            startActivity(intentStart)
        })
        val intentDetail = Intent(this@MainActivity3,MainActivity2::class.java )
        movieDetail.setOnClickListener({
            startActivity(intentDetail)
        })
    }
}
