package com.smartherd.msgshareappp

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickme = findViewById<Button>(R.id.Button)

        clickme.setOnClickListener {

            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }
    }
}