package com.example.androidpracticumcustomview.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.example.androidpracticumcustomview.DraggableControlPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.IllegalStateException

@Composable
fun CustomContainerCompose(
    firstChild: @Composable () -> Unit,
    secondChild: @Composable () -> Unit
) {

//    val controlPoint = remember { mutableStateOf(Offset(0f, 0f)) }


//

//
//    CustomBox(
//        modifier = Modifier
//            .fillMaxSize()
//            .offset(x = position.value.x.dp, y = position.value.y.dp)
//    ) {
//
//        firstChild()
//        secondChild()
//    }

    val startPositionOne = Offset(0f, 0f)
    val startPositionTwo = Offset(0f, 0f)
    val endPosition = Offset(50f, 50f)
    val position = remember { Animatable(startPositionOne, Offset.VectorConverter) }
    var visibility by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            visibility = !visibility
        }
        position.animateTo(
            targetValue = endPosition,
            animationSpec = keyframes {
                durationMillis = 5000
            }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .offset(x = position.value.x.dp, y = position.value.y.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visibility,
            enter = fadeIn(animationSpec = tween(durationMillis = 5000))
        ) {
            CustomBox(
                modifier = Modifier
            ) {
//                val startPositionOne = Offset(0f, 0f)
//                val startPositionTwo = Offset(0f, 0f)
//                val endPosition = Offset(50f, 50f)
//                val position = remember { Animatable(startPositionOne, Offset.VectorConverter) }
//
//                LaunchedEffect(visibility) {
//                    position.animateTo(
//                        targetValue = endPosition,
//                        animationSpec = keyframes {
//                            durationMillis = 5000
//                        }
//                    )
//                }
                firstChild()
                secondChild()
            }
        }
    }
}
