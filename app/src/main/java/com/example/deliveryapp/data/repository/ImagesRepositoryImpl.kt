package com.example.deliveryapp.data.repository

import com.example.deliveryapp.data.remote.dto.DishImageDto
import com.example.deliveryapp.data.repository.remote.ImagesRemote
import com.example.deliveryapp.domain.repository.ImageRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesRepositoryImpl @Inject constructor(
    private val imagesRemote: ImagesRemote
) : ImageRepository {
    override suspend fun getImage(category: String): List<DishImageDto> =
        imagesRemote.getImages(category)?.images.orEmpty()
}