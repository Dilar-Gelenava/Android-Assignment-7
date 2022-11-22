package com.example.android_assignment_7.api.models

import com.google.gson.annotations.SerializedName

data class User(
    val id: Long,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String
)
