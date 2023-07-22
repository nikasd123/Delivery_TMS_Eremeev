package com.example.deliveryapp.domain.repository

import com.example.deliveryapp.data.remote.dto.DishImageDto

interface ImageRepository {
    suspend fun getImage(category: String): List<DishImageDto>?
}