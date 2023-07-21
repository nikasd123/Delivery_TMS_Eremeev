package com.example.deliveryapp.data.repository

import com.example.deliveryapp.data.remote.dto.DataDishesDto
import com.example.deliveryapp.data.repository.local.ChoiceDishes
import com.example.deliveryapp.domain.repository.DishesChoiceRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DishesChoiceRepositoryImpl @Inject constructor(
    private val choiceDishes: ChoiceDishes
) : DishesChoiceRepository {
    override fun getDishes(): List<DataDishesDto> = choiceDishes.getDishes()
}