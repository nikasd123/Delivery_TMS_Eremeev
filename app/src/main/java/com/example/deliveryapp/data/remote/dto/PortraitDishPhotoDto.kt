package com.example.deliveryapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PortraitDishPhotoDto(
    @SerializedName("portrait")
    val portraitPhoto: String? = ""
)
