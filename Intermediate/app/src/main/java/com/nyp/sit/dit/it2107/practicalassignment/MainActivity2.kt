package com.nyp.sit.dit.it2107.practicalassignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*
import java.io.Serializable
class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val movie : Movie = Movie().getInstance()

        titleV.text  = movie.getTitle1()
        overView.text = movie.desc
        releaseView.text = movie.releaseDate
        langView.text =movie.langM
        suitable.text = movie.suit
        reviewThis.text = movie.review
//        val intentStart = Intent(this@MainActivity2,MainActivity::class.java )
//        addMovieButton.setOnClickListener({
//            startActivity(intentStart)
//        })
//        val intentRate = Intent(this@MainActivity2,MainActivity3::class.java )
//        intentRate.putExtra("movieName1",titleVar.text.toString())
//        movieRate.setOnClickListener({
//            startActivity(intentRate)
//        })
        registerForContextMenu(reviewThis)
    }
    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this@MainActivity2,MainActivity3::class.java )
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