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

        // Assigning data from my main page to variables
        val bundle: Bundle? = intent.extras
        // Getting the number entered by user as a string
        val tableString: String? = bundle?.getString("tableNumber")
        // Converting the string to an integer, default to 0 if null or invalid
        val tableNumber = tableString?.toIntOrNull() ?: 0
        
        val multiplyTable = findViewById<TextView>(R.id.tableDisplaytxt)
        var timeDisplay: String = "$tableNumber Times Table\n\n"

        // Creating counter for while loop
        var counter = 1

        while (counter <= 20) {
            val answer = tableNumber * counter
            // Appending each line to the timeDisplay string
            timeDisplay += "$tableNumber x $counter = $answer\n"
            counter++
        }

        // Displaying the full multiplication table after the loop finishes
        multiplyTable.text = timeDisplay

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
