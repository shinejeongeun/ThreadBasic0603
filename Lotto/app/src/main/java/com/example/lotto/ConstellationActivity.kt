package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val btnConstellationResult = findViewById<Button>(R.id.btnGoResult)
        btnConstellationResult.setOnClickListener {
            startActivity(Intent(this@ConstellationActivity, ResultActivity::class.java))
        }
    }
}