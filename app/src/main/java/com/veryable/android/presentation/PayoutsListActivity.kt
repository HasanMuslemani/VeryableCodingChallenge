package com.veryable.android.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.veryable.android.R
import com.veryable.android.data.repository.AccountRepositoryImpl
import com.veryable.android.presentation.accounts.AccountsScreen
import com.veryable.android.presentation.accounts.AccountsViewModel
import com.veryable.android.presentation.accounts.AccountsViewModelFactory
import com.veryable.android.presentation.accounts.components.AccountHeader
import com.veryable.android.presentation.accounts.components.AccountItem
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
                    AccountsScreen()
                }
            }
        }
    }
}