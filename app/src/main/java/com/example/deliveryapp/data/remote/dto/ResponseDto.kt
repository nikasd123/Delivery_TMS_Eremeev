package com.example.deliveryapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("photos")
    val images: List<ImageDto>
)