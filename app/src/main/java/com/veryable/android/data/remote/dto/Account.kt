package com.veryable.android.data.remote.dto


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Account(
    @SerializedName("account_name")
    val accountName: String?,
    @SerializedName("account_type")
    val accountType: String?,
    @SerializedName("desc")
    val desc: String?,
    @SerializedName("id")
    val id: Int?
) : Parcelable