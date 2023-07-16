package com.example.deliveryapp.data.repository

import com.example.deliveryapp.data.remote.dto.DataDishesDto
import com.example.deliveryapp.data.repository.local.DishesLocal
import com.example.deliveryapp.data.repository.remote.ImagesRemote
import com.example.deliveryapp.domain.repository.DishesChoiceRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DishesChoiceRepositoryImpl @Inject constructor(
    private val dishesLocal: DishesLocal
) : DishesChoiceRepository {
    override fun getDishes(): List<DataDishesDto> = dishesLocal.getDishes()
}