package com.example.deliveryapp.domain.repository

import com.example.deliveryapp.data.remote.dto.DataDishesDto

interface DishesRepository {
    fun getDishes(): List<DataDishesDto>
}