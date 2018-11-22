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
    val movie : Movie = Movie().getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        titleV.text  = movie.title
        overView.text = movie.desc
        releaseView.text = movie.releaseDate
        langView.text =movie.langM
        suitable.text = movie.suit
        reviewThis.text = movie.review

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