package com.veryable.android.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.veryable.android.presentation.account_details.AccountDetailsScreen
import com.veryable.android.presentation.accounts.AccountsScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.AccountsScreen.route) {
        composable(route = Screen.AccountsScreen.route) {
            AccountsScreen(navController = navController)
        }
        composable(route = Screen.AccountDetailsScreen.route) {
            AccountDetailsScreen(navController = navController)
        }
    }
}