package com.example.deliveryapp.data.remote.dto

import com.google.gson.annotations.SerializedName


data class ImagesResponseDto(
    @SerializedName("totalResults")
    val totalResults: Long?,

    @SerializedName("photos")
    val images: List<ImageDto>?
)