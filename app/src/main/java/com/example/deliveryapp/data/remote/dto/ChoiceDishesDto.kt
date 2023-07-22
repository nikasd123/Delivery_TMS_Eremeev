package com.example.deliveryapp.data.remote.dto

import com.example.deliveryapp.domain.models.DomainChoiceDishes
import com.example.deliveryapp.domain.models.DomainChoiceDishesList

data class DataDishesDto(
    val imageId: Int,
    val imageLogoId: Int,
    val title: String,
    val category: String = title
)

internal fun DataDishesDto.toDomainDishes() =
    DomainChoiceDishes(
        imageId = imageId,
        imageLogoId = imageLogoId,
        title = title
    )


internal fun List<DataDishesDto>.toDomainChoiceDishesList() =
    DomainChoiceDishesList(
        this.map {dataDishesDto ->
            dataDishesDto.toDomainDishes()
        }
    )