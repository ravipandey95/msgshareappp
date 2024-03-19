package com.smartherd.msgshareappp.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareappp.Constants
import com.smartherd.msgshareappp.R
import com.smartherd.msgshareappp.showToast

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_layout)

        //safe call ?.
        // safe call with let ?.let{ }
        val bundle: Bundle? = intent.extras

        bundle?.let{
            val msg = bundle.getString(Constants.USER_MSG_KEY)

            showToast(msg)

            val usrmsg = findViewById<TextView>(R.id.txvUserMessage)
            usrmsg.text = msg
        }

    }
}