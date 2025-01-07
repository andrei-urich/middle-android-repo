package com.example.androidpracticumcustomview.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import java.lang.IllegalStateException

@Composable
fun CustomBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
): Positions {

    var startPositionOne = 0
    var startPositionTwo = 0
    val endPositionOne = 0
    var endPositionTwo = 0

    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
        if (placeables.size > 2) {
            throw IllegalStateException("Exception message")
        } else {
            layout(constraints.maxWidth, constraints.maxHeight) {
                if (placeables[0] !== null) {
                    val yPositionOne = constraints.maxHeight / 2 - placeables[0].measuredHeight
                    val xPositionOne = (constraints.maxWidth - placeables[0].measuredWidth) / 2
                    placeables[0].place(xPositionOne, yPositionOne)
                    startPositionOne = yPositionOne
                }
                if (placeables[1] !== null) {
                    val yPositionTwo = constraints.maxHeight / 2
                    val xPositionTwo = (constraints.maxWidth - placeables[1].measuredWidth) / 2
                    placeables[1].place(xPositionTwo, yPositionTwo)
                    startPositionOne = yPositionTwo
                    endPositionTwo = constraints.maxHeight
                }
            }
        }
    }
    return Positions(
        startPositionOne,
        startPositionTwo,
        endPositionOne,
        endPositionTwo
    )
}