package com.example.recyclerviewusingdiffutilandlistadapter

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val programmingLanguageAdapter = ProgrammingLanguageAdapter()

        val pL1 = ProgrammingLanguage(1, "J", "Java")
        val pL2 = ProgrammingLanguage(2, "K", "Kotlin")
        val pL3 = ProgrammingLanguage(3, "P", "Python")

        programmingLanguageAdapter.submitList(listOf(pL1, pL2, pL3))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = programmingLanguageAdapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {

            val pL3 = ProgrammingLanguage(3, "J", "Python")
            val pL4 = ProgrammingLanguage(4, "S", "SQL")
            val pL5 = ProgrammingLanguage(5, "D", "Dart")
            val pL6 = ProgrammingLanguage(6, "C", "C#")

            programmingLanguageAdapter.submitList(listOf(pL3, pL4, pL5, pL6))

        }, 3500)

    }
}