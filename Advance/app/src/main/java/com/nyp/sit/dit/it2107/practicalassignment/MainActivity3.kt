package com.nyp.sit.dit.it2107.practicalassignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie = applicationContext as Movie
        setContentView(R.layout.activity_main3)
        reviewName.text=movie.getArray()!![0].getReview1()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.reviewmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val movie = applicationContext as Movie
        movie.getArray()!![0].setStar(ratingMe.rating)
        movie.getArray()!![0].setReview1(reviewMe.text.toString())
        val intention = Intent(applicationContext,MainActivity2::class.java)
        startActivity(intention)
        return super.onOptionsItemSelected(item)
    }
}
