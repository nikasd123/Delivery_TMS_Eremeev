package com.example.deliveryapp.data.repository.local

import com.example.deliveryapp.data.local.DishEntity

interface DishesLocal {
    suspend fun getSavedDishes(): List<DishEntity>?
    suspend fun insertDish(dishEntity: DishEntity)
    suspend fun deleteDish(dishEntity: DishEntity)
    suspend fun updateDish(dishEntity: DishEntity)
}