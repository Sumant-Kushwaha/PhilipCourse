package com.amigo.philipcourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable
fun CreateScaffold() {
    Scaffold(
        topBar = { TopBarExample() }
    ) {values->
        IconsExample()
        Modifier.padding(values)
    }
}

@Composable
fun TopBarExample() {
    val context= LocalContext.current
    TopAppBar(
        title = { Text(text = "Top App Bar") },
        navigationIcon = {
            IconButton(onClick = {
                android.widget.Toast.makeText(context,"Menu Opened", android.widget.Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Default.Menu, contentDescription = null)
            }
        }
    )
}

@Composable
fun IconsExample() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.FavoriteBorder, contentDescription = null)
    }
}