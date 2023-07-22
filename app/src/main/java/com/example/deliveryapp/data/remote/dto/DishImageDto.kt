package com.example.deliveryapp.data.remote.dto

import com.example.deliveryapp.domain.models.DomainDishes
import com.google.gson.annotations.SerializedName


data class DishImageDto(
    @SerializedName("id")
    val id: Long?,

    @SerializedName("src")
    val url: PortraitDishPhotoDto?,

    @SerializedName("alt")
    val name: String?
)


internal fun DishImageDto.toDomainDishes(): DomainDishes =
    DomainDishes(
        id = id,
        url = url?.portraitPhoto,
        name = name
    )