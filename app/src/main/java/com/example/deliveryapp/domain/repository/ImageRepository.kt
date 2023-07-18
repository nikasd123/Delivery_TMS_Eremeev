package com.example.deliveryapp.domain.repository

import com.example.deliveryapp.data.remote.dto.ImageDto

interface ImageRepository {
    suspend fun getImage(category: String): List<ImageDto>
}