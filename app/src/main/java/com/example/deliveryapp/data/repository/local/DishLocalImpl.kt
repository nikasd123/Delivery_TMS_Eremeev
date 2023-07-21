package com.example.deliveryapp.data.repository.local

import com.example.deliveryapp.data.local.DishEntity
import com.example.deliveryapp.data.local.DishesDao
import javax.inject.Inject

class DishLocalImpl @Inject constructor(
    private val dishesDao: DishesDao
): DishesLocal{
    override suspend fun getSavedDishes(): List<DishEntity> = dishesDao.getAllDishes()

    override suspend fun insertDish(dishEntity: DishEntity) {
        dishesDao.insertDish(dishEntity = dishEntity)
    }

    override suspend fun deleteDish(dishEntity: DishEntity) {
        dishesDao.deleteDish(dishEntity = dishEntity)
    }

    override suspend fun updateDish(dishEntity: DishEntity) {
        dishesDao.updateDish(dishEntity = dishEntity)
    }

}