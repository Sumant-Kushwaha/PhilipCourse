package com.amigo.philipcourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

enum class BottomIcon {
    List,
    Email
}

@Composable
fun BottomAppBar1() {
    Scaffold(
        bottomBar = { BottomAppBarExample() },
    ) {}
}

@Composable
fun BottomAppBarExample() {

    val selected = remember {
        mutableStateOf(BottomIcon.List)
    }
    BottomAppBar(content = {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Bottom Bar", fontSize = 20.sp)
            IconButton(onClick = { selected.value = BottomIcon.List }) {
                Icon(
                    Icons.Default.List, contentDescription = null,
                    tint = if (selected.value == BottomIcon.List) Color.Red else Color.White
                )
            }
            IconButton(onClick = { selected.value = BottomIcon.Email }) {
                Icon(
                    Icons.Default.Email, contentDescription = null,
                    tint = if (selected.value == BottomIcon.Email) Color.Red else Color.White
                )
            }
        }
    })
}