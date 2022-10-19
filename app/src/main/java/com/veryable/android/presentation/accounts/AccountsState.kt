package com.veryable.android.presentation.accounts

import com.veryable.android.data.remote.dto.Account
import com.veryable.android.data.remote.dto.Accounts

data class AccountsState (
    val isLoading: Boolean = false,
    val accounts: Accounts = Accounts(),
    val error: String = ""
)