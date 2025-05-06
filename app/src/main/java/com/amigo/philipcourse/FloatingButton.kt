package com.amigo.philipcourse

import android.widget.Toast.makeText
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable
fun RunFloatingButton() {
    Scaffold(
        floatingActionButton = { FloatingActionButtonExample() },
        floatingActionButtonPosition = FabPosition.Center,
//        isFloatingActionButtonDocked = false
    ) { values ->
        Modifier.padding(values)
    }
}


@Composable
fun FloatingActionButtonExample() {

    val context = LocalContext.current

    FloatingActionButton(onClick = { makeToast(context, "Floating Action \n Button Clicked") }) {
        Icon(Icons.Default.Add, contentDescription = null)
    }
}