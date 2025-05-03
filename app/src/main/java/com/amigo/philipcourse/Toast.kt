package com.amigo.philipcourse

import android.widget.Button
import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Toast() {
    val context= LocalContext.current
    Button(onClick = {
        Toast.makeText(context, "This is a toast", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "Show Toast")
    }
}