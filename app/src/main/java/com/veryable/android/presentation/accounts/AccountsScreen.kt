package com.veryable.android.presentation.accounts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.veryable.android.R
import com.veryable.android.data.repository.AccountRepositoryImpl
import com.veryable.android.presentation.accounts.components.AccountHeader
import com.veryable.android.presentation.accounts.components.AccountItem

@Composable
fun AccountsScreen() {
    val viewModel: AccountsViewModel = viewModel(
        factory = AccountsViewModelFactory(AccountRepositoryImpl())
    )
    val state = viewModel.accountsState.value
    if(state.isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
    else if(state.error.isNotEmpty()) {
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
    }
    else {
        val accountsGrouped = viewModel.accountsState.value.accounts.groupBy { it.accountType }
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
                        transferType = if (account.accountType == "bank") "Bank Account: ACH - Same Day" else "Card: Instant"
                    )
                }
            }
        }
    }
}