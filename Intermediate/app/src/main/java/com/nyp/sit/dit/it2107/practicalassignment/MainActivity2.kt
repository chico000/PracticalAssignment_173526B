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
        Log.i("Why?",movie.getTitle1())
        titleV.text  = movie.getTitle1()
        overView.text = movie.getDesc1()
        releaseView.text = movie.getDate()
        langView.text =movie.getLang1()
        suitable.text = movie.getSuit1()
        reviewThis.text = movie.getReview1()

        if (movie.getStar()>0F){
            rateXingXing.layoutParams.height=ActionBar.LayoutParams.WRAP_CONTENT
            rateXingXing.rating = movie.getStar()
            rateXingXing.visibility=View.VISIBLE
            noRating.visibility=View.INVISIBLE
        }

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

   
}