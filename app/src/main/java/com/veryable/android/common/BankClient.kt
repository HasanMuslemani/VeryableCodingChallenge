package com.veryable.android.common

import com.veryable.android.common.Constants.BASE_URL
import com.veryable.android.data.remote.BankService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BankClient {

    val bankClient by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BankService::class.java)
    }
}