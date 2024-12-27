package com.example.androidpracticumcustomview

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpracticumcustomview.ui.theme.CustomContainer

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
//        startXmlPracticum()
    }

//    private fun startXmlPracticum() {
//        val customContainer = CustomContainer(this)
//
//        val firstView = TextView(this).apply {
//            text = "1-st View"
//            textSize = 24F
//            setTextColor(getColor(R.color.white))
//
//        }
//
//        val secondView = TextView(this).apply {
//            text = "2-st View"
//            textSize = 24F
//            setTextColor(getColor(R.color.white))
//        }
//        customContainer.addView(firstView)
//        customContainer.addView(secondView)
//
//        // Добавление второго элемента через некоторое время
//        Handler(Looper.getMainLooper()).postDelayed({
//            customContainer.addView(secondView)
//        }, 2000)
//    }
}