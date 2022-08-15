package com.mramallo.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mramallo.newsapp.ui.news.NewsScreen
import com.mramallo.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

object Destinations {
    const val NEWS_SCREEN = "NEWS_SCREEN"
    const val DETAIL_SCREEN = "DETAIL_SCREEN"

}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Destinations.NEWS_SCREEN
                    ) {

                        composable(Destinations.NEWS_SCREEN) {
                            NewsScreen(navController = navController)
                        }

                        composable("${Destinations.DETAIL_SCREEN}/{newTitle}") {
                            // TODO: Navigation to details
                        }

                    }
                }
            }
        }
    }
}