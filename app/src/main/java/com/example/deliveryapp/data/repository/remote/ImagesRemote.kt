package com.example.deliveryapp.data.repository.remote

import com.example.deliveryapp.data.remote.dto.ImagesResponseDto

interface ImagesRemote {
    suspend fun getImages(category: String): ImagesResponseDto?
}