package com.veryable.android.data.repository

import com.veryable.android.data.remote.dto.Accounts

interface AccountRepository {

    suspend fun getAccounts() : Accounts
}