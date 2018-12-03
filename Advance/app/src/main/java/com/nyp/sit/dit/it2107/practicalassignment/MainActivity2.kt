package com.nyp.sit.dit.it2107.practicalassignment

import android.app.ActionBar
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*
import java.util.*
import java.io.Serializable
class MainActivity2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val movie = applicationContext as Movie
        for (i in movie.getArray()!!){
            Log.i("Why?",i.title)
        }

//        titleV.text  = movie.getArray()!![0].title
//        overView.text = movie.getArray()!![0].desc
//        releaseView.text = movie.getArray()!![0].releaseDate
//        langView.text =movie.getArray()!![0].langM
//        suitable.text = movie.getArray()!![0].suit
//        reviewThis.text = movie.getArray()!![0].getReview1()
//
//        if (movie.getArray()!![0].getStar()>0F){
//            rateXingXing.layoutParams.height=ActionBar.LayoutParams.WRAP_CONTENT
//            rateXingXing.rating = movie.getArray()!![0].getStar()
//            rateXingXing.visibility=View.VISIBLE
//            noRating.visibility=View.INVISIBLE
//        }

        registerForContextMenu(reviewThis)
    }
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(applicationContext,MainActivity3::class.java )
        if(item?.itemId == 1001){
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.reviewThis){
            menu?.add(1,1001,1,"Add Review")
        }
    }

    override fun onBackPressed() {
        val intention = Intent(applicationContext,LandingPage::class.java)
        startActivity(intention)
        super.onBackPressed()
    }
}