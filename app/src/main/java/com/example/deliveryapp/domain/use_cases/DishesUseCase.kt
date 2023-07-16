package com.example.deliveryapp.domain.use_cases

import com.example.deliveryapp.data.remote.dto.toDomainDishesList
import com.example.deliveryapp.domain.repository.DishesChoiceRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DishesUseCase @Inject constructor(
    private val dishesChoiceRepository: DishesChoiceRepository
){
    fun getDishes() = dishesChoiceRepository.getDishes().toDomainDishesList()
}