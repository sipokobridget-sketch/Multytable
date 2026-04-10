package com.example.multytable

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TableDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_table_display)

        //assigning data from my main page to variables
        val bundle: Bundle? = intent.extras
        //getting the number entered by user as a string
        val tableString: String? = bundle?.getString("tableNumber")
        //converting the string to an integer
        val tableNumber = tableString!!.toInt()
        val multiplyTable = findViewById<TextView>(R.id.tableDisplaytxt)
        var timeDisplay: String = "$tableNumber x table\n\n"

        //Creating counter for while loop
        var count = 1

        //displaying the multiplication table
        multiplyTable.text ="$tableNumber x table\n\n"

        while (count <= 10) {
            //example:user enters 5 and count is 1 so = 5*1 = 5
            val answer = tableNumber * count
            /*display as:
            5 x tables
            5x1=5
             */
            timeDisplay += "$tableNumber x$count =$(answe)\n"
            //increasing the count
            count++
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}