package com.smartherd.msgshareappp.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareappp.R
import com.smartherd.msgshareappp.showToast

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString("user_message")

        showToast(msg)

        val usrmsg = findViewById<TextView>(R.id.txvUserMessage)
        usrmsg.text = msg
    }
}