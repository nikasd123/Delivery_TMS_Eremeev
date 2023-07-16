package com.example.deliveryapp.domain.repository

import com.example.deliveryapp.data.remote.dto.DataDishesDto

interface DishesChoiceRepository {
    fun getDishes(): List<DataDishesDto>
}