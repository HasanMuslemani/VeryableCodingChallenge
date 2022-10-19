package com.veryable.android.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Account(
    @SerializedName("account_name")
    val accountName: String?,
    @SerializedName("account_type")
    val accountType: String?,
    @SerializedName("desc")
    val desc: String?,
    @SerializedName("id")
    val id: Int?
)