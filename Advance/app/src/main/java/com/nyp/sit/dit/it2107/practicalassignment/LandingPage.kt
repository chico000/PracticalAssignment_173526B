package com.nyp.sit.dit.it2107.practicalassignment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val movie = applicationContext as Movie
        val list = mutableListOf<Mov>()
        if(list.size>0){
            val adapter:customAdapter = customAdapter(applicationContext,R.layout.list_view,list)
            listViewMovie.adapter=adapter
        }


    }
    class customAdapter(var hi:Context,var resource: Int, var items:List<Mov>)
        : ArrayAdapter<Mov>(hi,resource,items){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var layoutInflater:LayoutInflater = LayoutInflater.from(hi)
            val view: View = layoutInflater.inflate(resource,null )

            val textView: TextView = view.findViewById(R.id.titleName)
            val image: ImageView = view.findViewById(R.id.imageMovie)
            val mov:Mov = items[position]
            textView.text=mov.title
            image.setImageResource(R.mipmap.ic_launcher_foreground)

            return view
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.add_new,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intention = Intent(applicationContext,MainActivity::class.java)
        startActivity(intention)
        return super.onOptionsItemSelected(item)
    }
}
