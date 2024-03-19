package com.smartherd.msgshareappp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.smartherd.msgshareappp.Constants
import com.smartherd.msgshareappp.R
import com.smartherd.msgshareappp.showToast

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG: String= MainActivity::class.java.simpleName
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usermsg = findViewById<EditText>(R.id.etusermessage)
        val clickme = findViewById<Button>(R.id.Btnshowtoast)
        clickme.setOnClickListener {
            Log.i(TAG, "Button was clicked!")
            showToast("Button clicked")
        }
        val clickmetwo = findViewById<Button>(R.id.btnSendMsgToNextActivity)
        clickmetwo.setOnClickListener {
            val message : String = usermsg.text.toString()
            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra(Constants.USER_MSG_KEY, message)
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
        val clickfour = findViewById<Button>(R.id.btnRecyclerViewDemo)
        clickfour.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java )
            startActivity(intent)
        }
    }
}