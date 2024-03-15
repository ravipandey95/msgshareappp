package com.smartherd.msgshareappp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usermsg = findViewById<EditText>(R.id.etusermessage)
        val clickme = findViewById<Button>(R.id.Btnshowtoast)
        clickme.setOnClickListener {
            Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        }
        val clickmetwo = findViewById<Button>(R.id.btnSendMsgToNextActivity)
        clickmetwo.setOnClickListener {
            val message : String = usermsg.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("user_message", message)
            startActivity(intent)
        }

        val clickthree = findViewById<Button>(R.id.btnShareToOtherApps)
        clickthree.setOnClickListener{
            val message : String = usermsg.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, " Share To :"))
        }
    }
}