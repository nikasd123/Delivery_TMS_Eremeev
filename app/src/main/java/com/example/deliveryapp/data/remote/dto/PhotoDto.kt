package com.example.deliveryapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PhotoDto(
    @SerializedName("portrait")
    val photo: String
)
