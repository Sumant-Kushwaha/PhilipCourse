package com.amigo.philipcourse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun GestureExample() {
    val gestureDetection= remember {
        mutableStateOf("No Gesture")
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = gestureDetection.value)
        var count by remember {
            mutableStateOf(0)
        }
        Box(
            modifier = Modifier
                .size(200.dp)
                .clickable {
                    count++
                }
                .pointerInput(Unit){
                    detectTapGestures(
                        onTap = {gestureDetection.value="onTap,x = ${it.x},y = ${it.y}"},
                        onPress = {gestureDetection.value="onPress"},
                        onDoubleTap = {gestureDetection.value="onDoubleTap"},
                        onLongPress = {gestureDetection.value="onLongPress"},
                    )
                }
        ) {
            Text(
                text = " Total click = $count",
                Modifier.align(Alignment.Center)
            )
        }
    }
}