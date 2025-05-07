package com.amigo.philipcourse.bottomnavigation

import android.widget.Toast
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.amigo.philipcourse.navigation.*

sealed class Destination(val route: String) {
    object Home : Destination("home")
    object Profile : Destination("profile")
    object Feed : Destination("feed")
    object List : Destination("list")
    object Details : Destination("details/{userId}") {
        fun createRoute(userId: Int) = "details/$userId"
    }
}


data class User(
    val id: Int,
    val name: String,
    val surname: String
) {
    companion object {
        private val users = listOf(
            User(0, "John", "Smith"),
            User(1, "Susan", "Smith"),
            User(2, "David", "Brown"),
            User(3, "Margaret", "Brown"),
            User(4, "Michael", "Jones"),
            User(5, "Patricia", "Jones"),
            User(6, "Andrew", "Williams"),
            User(7, "Sarah", "Williams"),
            User(8, "Robert", "Perry"),
            User(9, "Mary", "Perry"),
        )

        fun getTestList() = users

        fun getUser(id: Int): User? {
            for (i in users.indices) {
                if (users[i].id == id) return users[i]
            }
            return null
        }
    }
}


@Composable
fun MainBottomNav() {
    val navController = rememberNavController()
//    NavigationAppHost(navController = navController)
    BottomNavExample(navController = navController)
}

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable(Destination.Home.route) { HomeScreen(navController) }
        composable(Destination.Feed.route) { FeedScreen(navController) }
        composable(Destination.Profile.route) { ProfileScreen(navController) }
        composable(Destination.List.route) { ListScreen(navController) }
        composable(Destination.Details.route) { navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getString("userId")
            if (userId == null) {
                Toast.makeText(LocalContext.current, "User id is required", Toast.LENGTH_SHORT)
                    .show()
            } else
                DetailScreen(navController = navController, userId = userId.toInt())
        }
    }
}


@Composable
fun BottomNavExample(navController: NavHostController) {
    Scaffold(bottomBar = {
        BottomNavigation {
            val navBackStackEntry = navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry.value?.destination

            BottomNavigationItem(
                selected = currentDestination?.route == Destination.Home.route,
                onClick = { navController.navigate(Destination.Home.route) },
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                label = { Text(text = Destination.Home.route)}
            )

            BottomNavigationItem(
                selected = currentDestination?.route == Destination.Feed.route,
                onClick = { navController.navigate(Destination.Feed.route) },
                icon = { Icon(Icons.Default.List, contentDescription = null) },
                label = { Text(text = Destination.Feed.route)}
            )

            BottomNavigationItem(
                selected = currentDestination?.route == Destination.Profile.route,
                onClick = { navController.navigate(Destination.Profile.route) },
                icon = { Icon(Icons.Default.Person, contentDescription = null) },
                label = { Text(text = Destination.Profile.route)}
            )
        }
    }) { values ->
        NavHost(navController = navController, startDestination = Destination.Home.route) {
            composable(Destination.Home.route) { HomeScreen(navController) }
            composable(Destination.Feed.route) { FeedScreen(navController) }
            composable(Destination.Profile.route) { ProfileScreen(navController) }
        }
    }
}