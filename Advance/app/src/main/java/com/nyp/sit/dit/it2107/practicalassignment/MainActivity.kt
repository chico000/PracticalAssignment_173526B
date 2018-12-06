package com.nyp.sit.dit.it2107.practicalassignment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.Serializable
import java.util.*

class MainActivity : AppCompatActivity() {
    var violenceCheck = ""
    var languageCheck = ""
    var suitable1="True"
    var lang = ""


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notSuitable.setOnCheckedChangeListener { buttonView, isChecked ->
            if(notSuitable.isChecked){
                violence.visibility=View.VISIBLE
                languageUsed.visibility=View.VISIBLE
                suitable1="False"

            }else{
                violence.visibility=View.INVISIBLE
                languageUsed.visibility=View.INVISIBLE
                suitable1="True"
            }
        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if(englishLang.isChecked){
            lang = "${englishLang.text}"
        }else if(chineseLang.isChecked){
            lang = "${chineseLang.text}"
        }else if(malayLang.isChecked){
            lang = "${malayLang.text}"
        }else if (tamilLang.isChecked){
            lang = "${tamilLang.text}"
        }
        if (violence.isChecked and languageUsed.isChecked){
            violenceCheck="${violence.text}"
            languageCheck="${languageUsed.text}"
        }else if (languageUsed.isChecked){
            languageCheck="${languageUsed.text}"
            violenceCheck=""
        }else if (violence.isChecked){
            violenceCheck="${violence.text}"
            languageCheck=""
        }
        if (item?.itemId==R.id.addNew){


            if(movieName.text.isEmpty() and movieDesc.text.isEmpty() and releaseDate.text.isEmpty()){
                movieName.setError("Field Empty")
                movieDesc.setError("Field Empty")
                releaseDate.setError("Field Empty")
            }else if (movieName.text.isEmpty() and movieDesc.text.isEmpty()){
                movieName.setError("Field Empty")
                movieDesc.setError("Field Empty")
            }else if (movieName.text.isEmpty()and releaseDate.text.isEmpty()){
                movieName.setError("Field Empty")
                releaseDate.setError("Field Empty")
            }else if(movieDesc.text.isEmpty() and releaseDate.text.isEmpty()){
                movieDesc.setError("Field Empty")
                releaseDate.setError("Field Empty")
            }else if (movieName.text.isEmpty()){
                movieName.setError("Field Empty")
            }else if(movieDesc.text.isEmpty()){
                movieDesc.setError("Field Empty")
            }else if (releaseDate.text.isEmpty()){
                releaseDate.setError("Field Empty")
            }else {
                val toast=Toast.makeText(applicationContext,"Title = ${movieName.text} \n " +
                        "Overview = ${movieDesc.text} \n " +
                        "Release Date = ${releaseDate.text} \n " +
                        "Language = $lang \n " +
                        "Suitable for all ages = $suitable1 \n " +
                        "Reasons: \n ${violenceCheck.toString()} \n ${languageCheck.toString()}  ", Toast.LENGTH_LONG)

                toast.show()
                val movie = applicationContext as Movie
                val intention = Intent(applicationContext,MainActivity2::class.java )

                val movieEn = MovieEntity(  movieName.text.toString(),
                        movieDesc.text.toString(),
                        releaseDate.text.toString(),
                        suitable1.toString(),
                        lang.toString(),
                        languageCheck.toString(),
                        violenceCheck.toString())
                movie.addMovie(movieEn)
                startActivity(intention)


            }

        }else if (item?.itemId==R.id.clear){
            movieName.text=null
            movieDesc.text=null
            releaseDate.text=null
            notSuitable.isChecked= false
            violence.isChecked=false
            languageUsed.isChecked=false
        }


        return super.onOptionsItemSelected(item)
    }

}
