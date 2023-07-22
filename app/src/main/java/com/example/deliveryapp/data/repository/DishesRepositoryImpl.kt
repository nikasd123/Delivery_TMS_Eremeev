package com.example.deliveryapp.data.repository

import com.example.deliveryapp.data.local.DishEntity
import com.example.deliveryapp.data.repository.local.DishesLocal
import com.example.deliveryapp.domain.repository.DishRepository
import javax.inject.Inject

class DishesRepositoryImpl @Inject constructor(
    private val dishesLocal: DishesLocal
): DishRepository{
    override suspend fun getSavedDishes(): List<DishEntity>? =
        dishesLocal.getSavedDishes()

    override suspend fun removeDish(dishEntity: DishEntity) =
        dishesLocal.deleteDish(dishEntity)

    override suspend fun addDish(dishEntity: DishEntity) =
        dishesLocal.insertDish(dishEntity)
}