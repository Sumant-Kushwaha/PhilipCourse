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
fun FeedScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Feed Screen")

        Button(onClick = { navController.navigate(Destination.Home.route) }) {
            Text(text = "To Home Screen")
        }

        Button(onClick = {
            navController.navigate(Destination.Profile.route) {
                popUpTo(Destination.Home.route)
//                launchSingleTop=true
            }
        }) {
            Text(text = "To Profile Screen")
        }
    }
}