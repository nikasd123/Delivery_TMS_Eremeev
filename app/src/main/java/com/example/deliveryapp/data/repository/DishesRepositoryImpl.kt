package com.example.deliveryapp.data.repository

import com.example.deliveryapp.data.remote.dto.DataDishesDto
import com.example.deliveryapp.data.repository.remote.DishesRemote
import com.example.deliveryapp.domain.repository.DishesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DishesRepositoryImpl @Inject constructor(
    private val dishesRemote: DishesRemote
) : DishesRepository {
    override fun getDishes(): List<DataDishesDto> = dishesRemote.getDishes()
}