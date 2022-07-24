package com.mramallo.newsapp.ui.news

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController


@Composable
fun NewsScreen(
    navController: NavController,
    viewModel: ViewModel = hiltViewModel()
){}