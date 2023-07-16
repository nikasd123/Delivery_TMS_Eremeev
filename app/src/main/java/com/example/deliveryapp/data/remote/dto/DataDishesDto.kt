package com.example.deliveryapp.data.remote.dto

import com.example.deliveryapp.domain.models.DomainChoiceDishes
import com.example.deliveryapp.domain.models.DomainChoiceDishesList

data class DataDishesDto(
    val imageId: Int,
    val imageLogoId: Int,
    val title: String,
    val category: String = title
)

fun DataDishesDto.toDomainDishes() =
    DomainChoiceDishes(
        imageId = imageId,
        imageLogoId = imageLogoId,
        title = title,
        category = category
    )

fun List<DataDishesDto>.toDomainDishesList() =
    DomainChoiceDishesList(
        this.map {
            it.toDomainDishes()
        }
    )