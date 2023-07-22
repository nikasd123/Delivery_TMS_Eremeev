package com.example.deliveryapp.domain.use_cases

import com.example.deliveryapp.data.local.DishEntity
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.domain.repository.DishRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDishesUseCase @Inject constructor(
    private val dishRepository: DishRepository
) {
    suspend fun getSavedDishes(): List<DomainDishes>? =
        dishRepository.getSavedDishes()?.map { dishEntity ->
            DomainDishes(id = dishEntity.id, url = dishEntity.url, name = dishEntity.name)
        }

    suspend fun addDish(dish: DomainDishes) {
        val dishEntity = DishEntity(name = dish.name, url = dish.url, id = dish.id)
        dishRepository.addDish(dishEntity)
    }

    suspend fun removeDish(dish: DomainDishes) {
        val dishEntity = DishEntity(name = dish.name, url = dish.url, id = dish.id)
        dishRepository.removeDish(dishEntity)
    }
}