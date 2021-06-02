package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result") ?: return
        val sConstellation = intent.getStringExtra("constellation")
        val sSimpleDate = intent.getStringExtra("SimpleDate")

        val result_sorted = result?.sorted()

        val lottoBallImageStartId = R.drawable.ball_01
        val lottoBallImageId02 = R.drawable.ball_02
        val lottoBallImageId03 = R.drawable.ball_03


        sConstellation?.let{
            val resultLabel = findViewById<TextView>(R.id.resultLabel)
            resultLabel.text = "${sConstellation}의 ${sSimpleDate} 로또 번호입니다"
        }


        val imageView1 = findViewById<ImageView>(R.id.imageView1)
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        val imageView3 = findViewById<ImageView>(R.id.imageView3)
        val imageView4 = findViewById<ImageView>(R.id.imageView4)
        val imageView5 = findViewById<ImageView>(R.id.imageView5)
        val imageView6 = findViewById<ImageView>(R.id.imageView6)

        imageView1.setImageResource(lottoBallImageStartId + (result_sorted[0] - 1))
        imageView2.setImageResource(lottoBallImageStartId + (result_sorted[1] - 1))
        imageView3.setImageResource(lottoBallImageStartId + (result_sorted[2] - 1))
        imageView4.setImageResource(lottoBallImageStartId + (result_sorted[3] - 1))
        imageView5.setImageResource(lottoBallImageStartId + (result_sorted[4] - 1))
        imageView6.setImageResource(lottoBallImageStartId + (result_sorted[5] - 1))
    }
}