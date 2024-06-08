package com.example.mypracticeapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var DateEditText: EditText
    private lateinit var MorningScreenTimeEditText: EditText
    private lateinit var AfternoonScreenTimeEditText: EditText
    private lateinit var ActivityNotesEditText: EditText
    private val Date = ArrayList<String>()
    private val MorningScreenTime = ArrayList<Int>()
    private val AfternoonScreenTime = ArrayList<Int>()
    private val ActivityNotes = ArrayList<String>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        DateEditText = findViewById(R.id.DateEditText)
        MorningScreenTimeEditText = findViewById(R.id.MorningScreenEditText)
        AfternoonScreenTimeEditText = findViewById(R.id.AfternoonScreenEditText)
        ActivityNotesEditText = findViewById(R.id.ActivityNotesEditText)
        val detailedView = findViewById<Button>(R.id.detailedViewButton)
        val addButton = findViewById<Button>(R.id.addButton)
        val clearButton = findViewById<Button>(R.id.clearButton)

        addButton.setOnClickListener {
            addScreenTime()
        }

        clearButton.setOnClickListener {
            clearData()
        }

        detailedView.setOnClickListener {
            val intent = Intent (this, MainActivity3::class.java)
            intent.putStringArrayListExtra("Date", Date)
            intent.putIntegerArrayListExtra("MorningScreenTime", MorningScreenTime)
            intent.putIntegerArrayListExtra("AfternoonScreenTime", AfternoonScreenTime)
            intent.putStringArrayListExtra("ActivityNotes", ActivityNotes)
            //start activity
            startActivity(intent)
        }
    }

    private fun addScreenTime() {
        val date = DateEditText.text.toString()
        val morningScreenTime = MorningScreenTimeEditText.text.toString().toIntOrNull()
        val afternoonScreenTime = AfternoonScreenTimeEditText.text.toString().toIntOrNull()
        val notes = ActivityNotesEditText.text.toString()

        if (date.isNotEmpty() && morningScreenTime != null && afternoonScreenTime != null) {
            Date.add(date)
            MorningScreenTime.add(morningScreenTime)
            AfternoonScreenTime.add(afternoonScreenTime)
            ActivityNotes.add(notes)

            DateEditText.text.clear()
            MorningScreenTimeEditText.text.clear()
            AfternoonScreenTimeEditText.text.clear()
            ActivityNotesEditText.text.clear()

            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearData() {
        Date.clear()
        MorningScreenTime.clear()
        AfternoonScreenTime.clear()
        ActivityNotes.clear()

        DateEditText.text.clear()
        MorningScreenTimeEditText.text.clear()
        AfternoonScreenTimeEditText.text.clear()
        ActivityNotesEditText.text.clear()

        Toast.makeText(this,"Data cleared", Toast.LENGTH_SHORT).show()
    }
}