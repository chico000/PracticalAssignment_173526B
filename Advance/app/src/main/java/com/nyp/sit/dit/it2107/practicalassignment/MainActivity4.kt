package com.nyp.sit.dit.it2107.practicalassignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val movie = applicationContext as Movie
        val position = intent.getStringExtra("postion")
        val mov = movie.getMovie()[position.toInt()]
        movieName.setText( mov.title)
        movieDesc.setText(mov.desc)
        if (mov.langM == englishLang.text){
            englishLang.isChecked = true

        }else if(mov.langM == chineseLang.text){
            chineseLang.isChecked = true
        }else if (mov.langM == malayLang.text){
            malayLang.isChecked = true
        }else {
            tamilLang.isChecked = true
        }
        releaseDate.setText(mov.releaseDate)

        if(mov.suit == "False")
            notSuitable.isChecked = true

        if(mov.langUsed != "")
            languageUsed.isChecked = true
        if(mov.violenceSuit!="")
            violence.isChecked=true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.save,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId==R.id.saveBtn){
            val movie = applicationContext as Movie
            val position = intent.getStringExtra("postion")
            val mov = movie.getMovie()[position.toInt()]
            mov.title=movieName.text.toString()
            mov.desc=movieDesc.text.toString()
            mov.releaseDate=releaseDate.text.toString()
            if(!notSuitable.isChecked){
                mov.suit ="True"
            }else{
                mov.suit ="False"
            }
            if(englishLang.isChecked){
                mov.langM= "${englishLang.text}"
            }else if(chineseLang.isChecked){
                mov.langM = "${chineseLang.text}"
            }else if(malayLang.isChecked){
                mov.langM = "${malayLang.text}"
            }else if (tamilLang.isChecked){
                mov.langM = "${tamilLang.text}"
            }
            if (violence.isChecked and languageUsed.isChecked){
                mov.violenceSuit="${violence.text}"
                mov.langUsed="${languageUsed.text}"
            }else if (languageUsed.isChecked){
                mov.langUsed="${languageUsed.text}"
                mov.violenceSuit=""
            }else if (violence.isChecked){
                mov.violenceSuit="${violence.text}"
                mov.langUsed=""
            }
            val intention = Intent(applicationContext,MainActivity2::class.java )
            startActivity(intention)
    }else{
            val intention = Intent(applicationContext,LandingPage::class.java )
            startActivity(intention)
        }
        return super.onOptionsItemSelected(item)
    }
}
