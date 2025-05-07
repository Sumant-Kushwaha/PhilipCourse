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
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Profile Screen")

        Button(onClick = {
            navController.navigate(Destination.Feed.route) {
                popUpTo(Destination.Home.route)
            }
        }) {
            Text(text = "To Feed Screen")
        }

        Button(onClick = { navController.navigate(Destination.Home.route) }) {
            Text(text = "To Home Screen")
        }

        Button(onClick = { navController.popBackStack() }) {
            Text(text = "To Previous Screen")
        }
    }
}