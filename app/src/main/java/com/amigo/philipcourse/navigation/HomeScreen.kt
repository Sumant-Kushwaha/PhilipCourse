package com.amigo.philipcourse.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Home Screen")
        
        Button(onClick = { navController.navigate(Destination.Feed.route) }) {
            Text(text = "To Feed Screen")
        }

        Button(onClick = { navController.navigate(Destination.Profile.route)}) {
            Text(text = "To Profile Screen")
        }

        Button(onClick = { navController.navigate(Destination.List.route)}) {
            Text(text = "To List Screen")
        }
    }
}