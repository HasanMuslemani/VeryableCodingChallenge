package com.veryable.android.data.remote

import com.veryable.android.data.remote.dto.AccountsDto
import retrofit2.http.GET

interface BankService {

    @GET("/veryable.json")
    suspend fun accounts() : AccountsDto
}