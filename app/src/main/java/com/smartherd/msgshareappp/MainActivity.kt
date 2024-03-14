package com.smartherd.msgshareappp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickme = findViewById<Button>(R.id.Btnshowtoast)
        clickme.setOnClickListener {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }
        val clickmetwo = findViewById<Button>(R.id.btnSendMsgToNextActivity)
        clickmetwo.setOnClickListener {
            val usermsg = findViewById<EditText>(R.id.etusermessage)
            val message : String = usermsg.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("user_message", message)
            startActivity(intent)
        }
    }
}