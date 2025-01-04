package com.example.androidpracticumcustomview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidpracticumcustomview.ui.theme.CustomContainerCompose

class CustomViewActivityTwo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomContainerCompose(
                firstChild = { FirstChild() },
                secondChild = { SecondChild() }
            )
        }
    }

    @Preview
    @Composable
    private fun FirstChild() {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
        )
    }

    @Preview
    @Composable
    private fun SecondChild() {
        Text("Custom View Compose")
    }
}
