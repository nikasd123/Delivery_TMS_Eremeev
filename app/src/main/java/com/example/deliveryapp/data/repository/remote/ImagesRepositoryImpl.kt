package com.example.deliveryapp.data.repository.remote

import com.example.deliveryapp.data.remote.dto.ImageDto
import com.example.deliveryapp.domain.repository.ImageRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesRepositoryImpl @Inject constructor(
    private val imagesRemote: ImagesRemote
) : ImageRepository {
    override suspend fun getImage(category: String): List<ImageDto> =
        imagesRemote.getImages(category).images.orEmpty()
}