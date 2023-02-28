package com.example.wishlistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private val itemsList = ArrayList<wish>()
    private lateinit var customAdapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter

        var _store: TextView = findViewById(R.id.editTextTextPersonName)
        var _url : TextView = findViewById(R.id.editTextTextPersonName2)
        //var _price : TextView = findViewById(R.id.editTextNumber)

        val submit_btn = findViewById<Button>(R.id.button)

        //wish(url =  , store = , num = )
        submit_btn.setOnClickListener{
            prepareItems(_url , _store ,"Calories" )
        }
    }


    private fun prepareItems(_a: TextView, _b: TextView, _c: String) {
        itemsList.add(wish(url = _a, store =_b, num = _c.toString()))
        customAdapter.notifyDataSetChanged()
    }
}