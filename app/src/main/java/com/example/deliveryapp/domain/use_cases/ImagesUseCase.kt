package com.example.deliveryapp.domain.use_cases

import com.example.deliveryapp.data.remote.dto.toImage
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.domain.repository.ImageRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ImagesUseCase @Inject constructor(
    private val imageRepository: ImageRepository
) {
    suspend fun getImages(category: String): List<DomainDishes> =
        imageRepository.getImages(category).map {
            it.toImage()
        }
}