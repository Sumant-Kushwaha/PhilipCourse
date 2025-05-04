package com.amigo.philipcourse

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable
fun AlertDialogExample() {
    val openDialog = remember {
        mutableStateOf(false)
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { openDialog.value = true }) {
            Text(text = "Show Alert Dialog")
        }
        if (openDialog.value == true) {
            AlertDialog(onDismissRequest = { openDialog.value = false },
                title = { Text(text = "Hello")},
                text = { Text(text = "How are you")},
                confirmButton = {
                    Button(onClick = {  }) {
                        Text(text = "Good ")
                    }
                },
                dismissButton = {
                    Button(onClick = {  }) {
                        Text(text = "Bad")
                    }
                }
            )
        }

    }
}