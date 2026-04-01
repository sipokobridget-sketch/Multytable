package com.example.multytable

import android.content.Intent
import android.os.Bundle
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

        val multiplication = findViewById<Button>(R.id.multplyBtn)
        val numInput = findViewById<EditText>(R.id.numTextInput)

        //created a button click listener to listen for the button click
        multiplication.setOnClickListener {
            /*Created an intent to switch between pages(switching from main activity to table display activity)*/
            val intent = Intent(this, TableDisplay::class.java)
            //start activity
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}