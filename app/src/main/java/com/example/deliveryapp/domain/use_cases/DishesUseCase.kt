package com.example.deliveryapp.domain.use_cases

import com.example.deliveryapp.data.remote.dto.toDomainDishesList
import com.example.deliveryapp.domain.repository.DishesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DishesUseCase @Inject constructor(
    private val dishesRepository: DishesRepository
){
    fun getDishes() = dishesRepository.getDishes().toDomainDishesList()
}