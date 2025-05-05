package com.amigo.philipcourse

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable
fun CreateScaffold() {
    Scaffold(
        topBar = { TopBarExample() }
    ) { values ->
        IconsExample()
        Modifier.padding(values)
    }
}

@Composable
fun TopBarExample() {
    val showMenu= remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    TopAppBar(
        title = { Text(text = "Top App Bar") },
        navigationIcon = {
            IconButton(onClick = {
                android.widget.Toast.makeText(
                    context,
                    "Menu Opened",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }) {
                Icon(Icons.Default.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = {  }) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = null)
            }
            IconButton(onClick = {showMenu.value=true}) {
                Icon(Icons.Default.MoreVert, contentDescription = null)                
            }
            DropdownMenu(expanded = showMenu.value, onDismissRequest = { showMenu.value = false }) {
                DropdownMenuItem(onClick = { makeToast(context,"More Icons") }) {
                    Icon(Icons.Default.Person, contentDescription = null)
                    Text(text = "Person")
                }
                DropdownMenuItem(onClick = { makeToast(context,"More Icons") }) {
                    Icon(Icons.Default.MailOutline, contentDescription = null)
                    Text(text = "Mail")
                }
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


fun makeToast(conx:Context,msg:String){
    android.widget.Toast.makeText(conx,msg, android.widget.Toast.LENGTH_SHORT).show()
}