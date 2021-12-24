package com.example.harajtask

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harajtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val list = ArrayList<DataHaraj>()
    lateinit var adapter:DataAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layManager = LinearLayoutManager(this)
        binding.rvPosts.layoutManager = layManager

        adapter = DataAdapter(this, list)

        binding.rvPosts.adapter = adapter

        dataModel()

    }

    fun dataModel(){
        val dataT = DataT(this)
        val dataV = ViewModelProvider(this, dataT).get(DataViewModel::class.java)
        dataV.getMutable().observe(this, Observer {
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

}