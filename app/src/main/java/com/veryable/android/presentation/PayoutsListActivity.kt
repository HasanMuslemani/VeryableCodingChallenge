package com.veryable.android.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewmodel.compose.viewModel
import com.veryable.android.data.remote.dto.Accounts
import com.veryable.android.data.repository.AccountRepository
import com.veryable.android.data.repository.AccountRepositoryImpl
import com.veryable.android.databinding.ActivityPayoutsListBinding
import com.veryable.android.presentation.accounts.AccountsViewModel
import com.veryable.android.presentation.accounts.AccountsViewModelFactory
import com.veryable.android.presentation.theme.BankTheme

class PayoutsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            backgroundColor = MaterialTheme.colors.secondary
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
                    val viewModel: AccountsViewModel = viewModel(
                        factory = AccountsViewModelFactory(AccountRepositoryImpl())
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.secondaryVariant),
                    ) {
                        val state = viewModel.accountsState.value
                        if(state.isLoading || state.error.isNotEmpty()) {

                        }
                        else {
                            state.accounts.forEach { account ->
                                Text(account.accountName ?: "Unknown name", style = MaterialTheme.typography.h3, color = MaterialTheme.colors.onSecondary)
                            }
                        }
                    }
                }
            }
        }
    }
}