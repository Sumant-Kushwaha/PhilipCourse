package com.amigo.philipcourse.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation(){
    val navController= rememberNavController()
    NavigationAppHost(navController=navController)
}

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home"){
        composable(Destination.Home.route) { HomeScreen(navController) }
        composable(Destination.Feed.route) { FeedScreen(navController) }
        composable(Destination.Profile.route) { ProfileScreen(navController) }
    }
}