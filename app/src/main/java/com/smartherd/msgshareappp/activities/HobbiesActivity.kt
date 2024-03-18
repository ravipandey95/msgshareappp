package com.smartherd.msgshareappp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.smartherd.msgshareappp.R
import com.smartherd.msgshareappp.adapters.HobbiesAdapter
import com.smartherd.msgshareappp.models.Supplier

class HobbiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        setupRecyclerView()
    }
    private fun setupRecyclerView() {
        val rcycl = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rcycl.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        rcycl.adapter = adapter
    }
}
