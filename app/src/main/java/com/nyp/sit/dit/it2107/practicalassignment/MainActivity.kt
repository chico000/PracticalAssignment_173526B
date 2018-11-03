package com.nyp.sit.dit.it2107.practicalassignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var suitable1="True"
        val intent = Intent(this@MainActivity,MainActivity2::class.java )

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

        addMovie.setOnClickListener({
            var violenceCheck = ""
            var languageCheck = ""
            if (violence.isChecked and languageUsed.isChecked){
                violenceCheck="${violence.text}"
                languageCheck="${languageUsed.text}"
            }else if (languageUsed.isChecked){
                languageCheck="${languageUsed.text}"
            }else if (violence.isChecked){
                violenceCheck="${violence.text}"
            }

            var lang = ""
            if(englishLang.isChecked){
                lang = "${englishLang.text}"
            }else if(chineseLang.isChecked){
                lang = "${chineseLang.text}"
            }else if(malayLang.isChecked){
                lang = "${malayLang.text}"
            }else if (tamilLang.isChecked){
                lang = "${tamilLang.text}"
            }
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
                        "Reasons: \n $violenceCheck \n $languageCheck  ", Toast.LENGTH_LONG)

                toast.show()
                intent.putExtra("movieName",movieName.text.toString())
                intent.putExtra("movieDesc",movieDesc.text.toString())
                intent.putExtra("releaseDate",releaseDate.text.toString())
                intent.putExtra("language",lang.toString())
                if(notSuitable.isChecked){
                    intent.putExtra("notSuitable","No")
                }else{
                    intent.putExtra("notSuitable","Yes")
                }


                nextButton.visibility=View.VISIBLE
            }


        })

        nextButton.setOnClickListener({
            startActivity(intent)
        })

    }

}
