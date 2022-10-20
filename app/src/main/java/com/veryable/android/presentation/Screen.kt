package com.veryable.android.presentation

sealed class Screen(val route: String) {
    object AccountsScreen : Screen("accounts_screen")
    object AccountDetailsScreen : Screen("account_details_screen")
}
