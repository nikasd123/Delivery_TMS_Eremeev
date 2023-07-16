package com.example.deliveryapp.data.repository.local

import com.example.deliveryapp.data.remote.dto.DataDishesDto

interface DishesLocal {
    fun getDishes(): List<DataDishesDto>
}