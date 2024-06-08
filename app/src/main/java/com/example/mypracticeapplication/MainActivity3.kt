package com.example.mypracticeapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    private lateinit var DetailsTextView: TextView
    private lateinit var AverageTextView: TextView
    private lateinit var backButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        DetailsTextView = findViewById(R.id.DetailsTextView)
        AverageTextView = findViewById(R.id.AverageTextView)
        backButton = findViewById(R.id.backButton)

        val Date = intent.getStringArrayListExtra("dates") ?: arrayListOf()
        val MorningScreenTime = intent.getStringArrayListExtra("MorningScreenTime") ?: arrayListOf()
        val AfternoonScreenTime = intent.getStringArrayListExtra("AfternoonScreenTime") ?: arrayListOf()
        val ActivityNotes = intent.getStringArrayListExtra("ActivityNotes") ?: arrayListOf()

        val details = StringBuilder()
        var totalScreenTime = 0
        for (i in Date.indices) {
            details.append("${Date[i]}:" +
                    " Morning - ${MorningScreenTime[i]} mins, Afternoon -" +
                    "${AfternoonScreenTime[i]} min, Notes - ${ActivityNotes[i]}\n")

            totalScreenTime += MorningScreenTime[i] + AfternoonScreenTime[i]
        }
        val AverageScreenTime = if (Date.isNotEmpty()) totalScreenTime / Date.size else 0
        DetailsTextView.text = details.toString()
        AverageTextView.text = "Average screen time: $AverageScreenTime mins"

        backButton.setOnClickListener {
            finish()
        }

    }
}

private operator fun Int.plusAssign(s: String) {


}

