package com.veryable.android.presentation.accounts

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.veryable.android.data.repository.AccountRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AccountsViewModel(
    private val repository: AccountRepository
) : ViewModel() {

    private val _state = mutableStateOf(AccountsState())
    val accountsState: State<AccountsState> = _state

    init {
        getAccounts()
    }

    fun getAccounts() {
        viewModelScope.launch {
            try {
                _state.value = AccountsState(isLoading = true)
                val accounts = repository.getAccounts()
                _state.value = AccountsState(accounts = accounts)
            }
            catch(e: HttpException) {
                _state.value = AccountsState(error = e.localizedMessage ?: "An unexpected error has occurred.")
            }
            catch(e: IOException) {
                _state.value = AccountsState(error = "Couldn't reach server. Check your internet connection.")
            }
        }
    }
}

class AccountsViewModelFactory constructor(
    private val repository: AccountRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AccountsViewModel(repository = repository) as T
    }
}