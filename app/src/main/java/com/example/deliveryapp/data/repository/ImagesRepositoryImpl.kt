package com.example.deliveryapp.data.repository

import com.example.deliveryapp.data.remote.dto.ImageDto
import com.example.deliveryapp.data.repository.remote.ImagesRemote
import com.example.deliveryapp.domain.repository.ImageRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesRepositoryImpl @Inject constructor(
    private val imagesRemote: ImagesRemote
) : ImageRepository {
    override suspend fun getImages(category: String): List<ImageDto> =
        imagesRemote.getImages(category).images.orEmpty()
}