package com.nyp.sit.dit.it2107.practicalassignment

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPage : AppCompatActivity() {
    var pos:Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        registerForContextMenu(listView)
        val movie = applicationContext as Movie


        if(movie.getMovie().isNotEmpty()) {
            val adapter = Adapter(applicationContext, movie.getMovie())
            listView.adapter = adapter

        }




    }
    class Adapter(private val context: Context,
                        private val dataSource: ArrayList<MovieEntity>) : BaseAdapter() {

        private val inflater: LayoutInflater
                = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //1
        override fun getCount(): Int {
            return dataSource.size
        }

        //2
        override fun getItem(position: Int): Any {
            return dataSource[position]
        }

        //3
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //4
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            // Get view for row item
            val rowView = inflater.inflate(R.layout.list_view, parent, false)
            val mov = getItem(position) as MovieEntity
            var titleName = rowView.findViewById(R.id.titleName) as TextView
            titleName.text = mov.title
            val thumbnailImageView = rowView.findViewById(R.id.imageMovie) as ImageView
            thumbnailImageView.setImageResource(R.mipmap.ic_launcher_foreground)

            return rowView
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.addmovie,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val intention = Intent(applicationContext,MainActivity::class.java )
        startActivity(intention)
        return super.onOptionsItemSelected(item)

    }
//    override fun onContextItemSelected(item: MenuItem?): Boolean {
//        val intent = Intent(this@LandingPage,MainActivity::class.java )
//        if(item?.itemId == 1001){
//            startActivity(intent)
//        }
//        return super.onContextItemSelected(item)
//    }
//
//    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        if(v?.id == R.id.landingText){
//            menu?.add(1,1001,1,"Add")
//        }
//    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        val intent = Intent(this@LandingPage,MainActivity::class.java )
        if(item?.itemId == 1001){

            val intention = Intent(applicationContext,MainActivity4::class.java)
            intention.putExtra("position",pos)

            startActivity(intention)
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.listView){
            menu?.add(1,1001,1,"Edit")
        }
    }

}
