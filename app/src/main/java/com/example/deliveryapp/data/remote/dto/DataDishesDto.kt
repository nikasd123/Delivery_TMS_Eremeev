package com.example.deliveryapp.data.remote.dto

import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.domain.models.DomainDishesList

data class DataDishesDto(
    val imageId: Int,
    val imageLogoId: Int,
    val title: String,
    val category: String = title
)

fun DataDishesDto.toDomainDishes() =
    DomainDishes(
        imageId = imageId,
        imageLogoId = imageLogoId,
        title = title,
        category = category
    )

fun List<DataDishesDto>.toDomainDishesList() =
    DomainDishesList(
        this.map {
            it.toDomainDishes()
        }
    )