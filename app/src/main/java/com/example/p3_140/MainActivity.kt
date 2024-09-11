package com.example.p3_140

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn1 = findViewById<Button>(R.id.btn1)
        val edittext=findViewById<EditText>(R.id.main_edit_text)
        btn1.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            intent.putExtra("username",edittext.text.toString())
            startActivity(intent)
        }
        val webpagebtn=findViewById<Button>(R.id.webpagebtn)
        val callbtn=findViewById<Button>(R.id.callbtn)
        val camerabtn=findViewById<Button>(R.id.camerabtn)
        val calllog=findViewById<Button>(R.id.calllog)
        val galleryview=findViewById<Button>(R.id.galleryview)
        val alarmbtn=findViewById<Button>(R.id.alarmbtn)

        webpagebtn.setOnClickListener {
            val webedittext=findViewById<EditText>(R.id.webedittext)
            val text=webedittext.text.toString()
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse(text))
            startActivity(intent)
        }

        callbtn.setOnClickListener {
            val phoneinput=findViewById<EditText>(R.id.phoneinput)
            val text=phoneinput.text
            val intent=Intent(Intent.ACTION_DIAL,Uri.parse("tel:+${text}"))
//            intent.data=Uri.parse("tel:+${text}")
            startActivity(intent)
        }

        camerabtn.setOnClickListener {
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        calllog.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE)
            startActivity(intent)
        }

        galleryview.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("image/*").also {
                startActivity(it)
            }
        }

        alarmbtn.setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also {
                startActivity(it)
            }
        }

    }
}