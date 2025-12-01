package com.example.exercise_11

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.core.tween  // FIXED!
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.sumgreeting.ui.HomeScreen
import com.example.sumgreeting.ui.SecondScreen
import com.example.sumgreeting.ui.ThirdScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "home") {
                        composable(
                            "home",
                            enterTransition = { fadeIn(tween(700)) },
                            exitTransition = { fadeOut(tween(700)) }
                        ) {
                            HomeScreen(navController)
                        }
                        composable(
                            "second/{name}",
                            arguments = listOf(navArgument("name") { type = NavType.StringType }),
                            enterTransition = { fadeIn(tween(700)) },
                            exitTransition = { fadeOut(tween(700)) }
                        ) { backStackEntry ->
                            val name = backStackEntry.arguments?.getString("name") ?: ""
                            SecondScreen(navController, name)
                        }
                        composable(
                            "third/{name}/{sum}",
                            arguments = listOf(
                                navArgument("name") { type = NavType.StringType },
                                navArgument("sum") { type = NavType.IntType }
                            ),
                            enterTransition = { fadeIn(tween(700)) },
                            exitTransition = { fadeOut(tween(700)) }
                        ) { backStackEntry ->
                            val name = backStackEntry.arguments?.getString("name") ?: ""
                            val sum = backStackEntry.arguments?.getInt("sum") ?: 0
                            ThirdScreen(navController, name, sum)
                        }
                    }
                }
            }
        }
    }
}