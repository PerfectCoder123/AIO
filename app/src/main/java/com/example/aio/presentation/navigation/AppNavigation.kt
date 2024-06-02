package com.example.aio.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aio.presentation.ui.category.CategoryView
import com.example.aio.presentation.ui.category.components.AppView
import com.example.aio.presentation.ui.home.Home
import com.example.aio.presentation.ui.home.utility.BrandList
import com.example.aio.presentation.ui.splash.Splash

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "splash") {
        composable("splash") {
            Splash(navController)
        }
        composable("home") {
            Home(navController)
        }
        composable("all-category") {
            CategoryView(navController = navController)
        }
        composable("app-category/{category}") {
            it.arguments?.getString("category")?.let { it1 -> AppView(header = it1) }
        }
    }
}