package com.example.deliveryapp.di.module

import com.example.deliveryapp.domain.repository.DishesChoiceRepository
import com.example.deliveryapp.domain.repository.ImageRepository
import com.example.deliveryapp.domain.use_cases.DishesUseCase
import com.example.deliveryapp.domain.use_cases.ImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideDishesUseCase(dishesChoiceRepository: DishesChoiceRepository) =
        DishesUseCase(dishesChoiceRepository = dishesChoiceRepository)

    @Provides
    fun provideImagesUseCase(imageRepository: ImageRepository) =
        ImagesUseCase(imageRepository = imageRepository)
}