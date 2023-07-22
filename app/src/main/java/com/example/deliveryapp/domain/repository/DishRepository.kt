package com.example.deliveryapp.domain.repository

import com.example.deliveryapp.data.local.DishEntity

interface DishRepository {
    suspend fun getSavedDishes(): List<DishEntity>?
    suspend fun removeDish(dishEntity: DishEntity)
    suspend fun addDish(dishEntity: DishEntity)
}