package com.example.deliveryapp.data.remote.dto

import com.example.deliveryapp.domain.models.DomainDishes
import com.google.gson.annotations.SerializedName


data class ImageDto(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("src")
    val url: PhotoDto?,

    @SerializedName("alt")
    val name: String?
)


internal fun ImageDto.toDomainDishes(): DomainDishes =
     DomainDishes(
        id = id,
        url = url?.photo,
        name = name
    )