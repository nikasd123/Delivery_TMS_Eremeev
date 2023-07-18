package com.example.deliveryapp.data.remote.dto

import com.example.deliveryapp.domain.models.DomainDishes
import com.google.gson.annotations.SerializedName

data class ImageDto(
    @SerializedName("id")
    val id: Int? = 0,

    @SerializedName("src")
    val url: PhotoDto?,

    @SerializedName("alt")
    val name: String? = "",
)

fun ImageDto.toImage(): DomainDishes {
    val imageUrl = url?.photo

    return DomainDishes(
        id = id,
        url = imageUrl,
        name = name
    )
}