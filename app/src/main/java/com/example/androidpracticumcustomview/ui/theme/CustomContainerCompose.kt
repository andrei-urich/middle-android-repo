package com.example.androidpracticumcustomview.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.Layout

/*
Задание:
Реализуйте необходимые компоненты;
Создайте проверку что дочерних элементов не более 2-х;
Предусмотрите обработку ошибок рендера дочерних элементов.
Задание по желанию:
Предусмотрите параметризацию длительности анимации.
 */
@Composable
fun CustomContainerCompose(
    content: @Composable () -> Unit
) {

    Layout(content) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }
        layout(constraints.maxWidth, constraints.maxHeight) {
            var yPosition = constraints.maxHeight / 2
            var xPosition = constraints.maxWidth / 2

            if (placeables[0] !== null) {
                yPosition = constraints.maxHeight / 2 - placeables[0].measuredHeight
                xPosition = (constraints.maxWidth - placeables[0].measuredWidth) / 2
                placeables[0].placeRelative(xPosition, yPosition)
            }
            if (placeables[1] !== null) {
                yPosition = constraints.maxHeight / 2
                xPosition = (constraints.maxWidth - placeables[1].measuredWidth) / 2
                placeables[1].placeRelative(xPosition, yPosition)
            }
        }
    }
}