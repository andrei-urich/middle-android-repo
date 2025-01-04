package com.example.androidpracticumcustomview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.androidpracticumcustomview.ui.theme.CustomContainerCompose

class CustomViewActivityTwo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomContainerCompose() {
                Text("First", fontSize = 20.sp, style = TextStyle(background = Color.Red))
                Text("Second", fontSize = 20.sp, style = TextStyle(background = Color.LightGray))
            }
        }
    }
}
