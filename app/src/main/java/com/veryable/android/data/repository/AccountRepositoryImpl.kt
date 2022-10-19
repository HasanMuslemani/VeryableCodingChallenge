package com.veryable.android.data.repository

import com.veryable.android.common.BankClient.bankClient
import com.veryable.android.data.remote.dto.Accounts

class AccountRepositoryImpl : AccountRepository {

    override suspend fun getAccounts(): Accounts {
        return bankClient.accounts()
    }
}