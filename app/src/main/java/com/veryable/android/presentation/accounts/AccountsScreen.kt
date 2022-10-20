package com.veryable.android.presentation.accounts

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.veryable.android.R
import com.veryable.android.data.repository.AccountRepositoryImpl
import com.veryable.android.presentation.Screen
import com.veryable.android.presentation.accounts.components.AccountHeader
import com.veryable.android.presentation.accounts.components.AccountItem

@Composable
fun AccountsScreen(
    navController: NavController
) {
    val viewModel: AccountsViewModel = viewModel(
        factory = AccountsViewModelFactory(AccountRepositoryImpl())
    )
    val state = viewModel.accountsState.value

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.secondary,
            ) {
                Text(
                    "ACCOUNTS",
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSecondary,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.secondaryVariant)
        ) {
            if (state.isLoading) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            } else if (state.error.isNotEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        state.error,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colors.onSecondary,
                        style = MaterialTheme.typography.h2
                    )
                }
            } else {
                val accountsGrouped =
                    viewModel.accountsState.value.accounts.groupBy { it.accountType }
                LazyColumn {
                    accountsGrouped.forEach { (accountType, accounts) ->
                        item {
                            AccountHeader(if (accountType == "bank") "Bank Accounts" else "Cards")
                        }
                        items(accounts) { account ->
                            AccountItem(
                                drawable = if (account.accountType == "bank") R.drawable.account_icon else R.drawable.card_icon,
                                name = account.accountName ?: "",
                                description = account.desc ?: "",
                                transferType = if (account.accountType == "bank") "Bank Account: ACH - Same Day" else "Card: Instant",
                                onClick = {
                                    navController.currentBackStackEntry?.savedStateHandle?.set(
                                        key = "account",
                                        value = account
                                    )
                                    navController.navigate(Screen.AccountDetailsScreen.route)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}