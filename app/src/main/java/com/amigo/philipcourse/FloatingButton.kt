package com.amigo.philipcourse

import android.widget.Toast.makeText
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch


@Composable
fun RunFloatingButton() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        floatingActionButton = { FloatingActionButtonExample(scaffoldState) },
        floatingActionButtonPosition = FabPosition.Center,
//        isFloatingActionButtonDocked = false
        scaffoldState = scaffoldState
    ) { values ->
        Modifier.padding(values)
    }
}


@Composable
fun FloatingActionButtonExample(state: ScaffoldState) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    FloatingActionButton(onClick = {
//        makeToast(context, "Floating Action \n Button Clicked")
        coroutineScope.launch {
            val result = state.snackbarHostState.showSnackbar(
                message = "Fab Clicked",
                duration = SnackbarDuration.Short,
                actionLabel = "Action"
            )
            when (result) {
                SnackbarResult.ActionPerformed -> {
                    makeToast(context, "SnackBar Action Performed")
                }
                SnackbarResult.Dismissed -> {
                    makeToast(context, "SnackBar Action Dismissed")
                }
                else -> {}
            }
        }
    }) {
        Icon(Icons.Default.Add, contentDescription = null)
    }
}