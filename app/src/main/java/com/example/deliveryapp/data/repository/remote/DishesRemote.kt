package com.example.deliveryapp.data.repository.remote

import com.example.deliveryapp.data.remote.dto.DataDishesDto

interface DishesRemote {
    fun getDishes(): List<DataDishesDto>
}