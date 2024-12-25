package com.example.androidpracticumcustomview.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {},
            colors = ButtonColors(
                Color.Blue,
                Color.White,
                Color.Blue,
                Color.White
            ),
        ) {
            Text(
                text = "Screen_1 CustomView on Views",
                modifier = Modifier,
                color = Color.White,
                fontSize = 14.sp,
            )
        }
        Spacer(
            modifier = Modifier.height(40.dp)
        )
        Button(
            onClick = {}
        ) {
            Text(
                text = "Screen_2 CustomView on Compose",
                modifier = Modifier,
                color = Color.White,
                fontSize = 14.sp,
            )
        }
    }
}
