package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

fun getShuffledLottoNumbersFromHash(str: String): MutableList<Int> {
    val list = mutableListOf<Int>()

    for (number in 1..45) {
        list.add(number)
    }

    val targetString = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SS", Locale.KOREA).format(Date())+str
    list.shuffle(Random(targetString.hashCode().toLong()))

    return list.subList(0,6)
}

class ConstellationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        val result = intent.getIntegerArrayListExtra("result") ?: return
        val strConstellation = intent.getStringExtra("constellation")

        val result_sorted = result?.sorted()


        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val btnGoResultConstell = findViewById<Button>(R.id.btnGoResult)
        val txtConstell = findViewById<TextView>(R.id.txtCostell)
        txtConstell.text = makeConstellationString(datePicker.month,datePicker.dayOfMonth)

        btnGoResultConstell.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getShuffledLottoNumbers(txtConstell.text.toString())))
            intent.putExtra("constellation", makeConstellationString(datePicker.month + 1, datePicker.dayOfMonth))
            startActivity(intent)
        }
    }


    }

    private fun makeConstellationString(month: Int, dayOfMonth: Int): String {
        val target = "${month}${String.format("%02d",dayOfMonth)}".toInt()

        when (target) {
            in 101..119 -> return "염소자리"
            in 120..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭자리"
            in 1023..1122-> return "전갈자리"
            in 1123..1224-> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else -> return "기타별자리"
        }


    }