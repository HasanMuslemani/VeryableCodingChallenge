package com.veryable.android.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewmodel.compose.viewModel
import com.veryable.android.data.remote.dto.Accounts
import com.veryable.android.data.repository.AccountRepository
import com.veryable.android.data.repository.AccountRepositoryImpl
import com.veryable.android.databinding.ActivityPayoutsListBinding
import com.veryable.android.presentation.accounts.AccountsViewModel
import com.veryable.android.presentation.accounts.AccountsViewModelFactory

class PayoutsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: AccountsViewModel = viewModel(
                factory = AccountsViewModelFactory(AccountRepositoryImpl())
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                val state = viewModel.accountsState.value
                if(state.isLoading || state.error.isNotEmpty()) {

                }
                else {
                    state.accounts.forEach { account ->
                        Text(account.accountName ?: "Unknown name")
                    }
                }
            }
        }
    }
}