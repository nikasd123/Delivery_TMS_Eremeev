package com.example.deliveryapp.di.module

import com.example.deliveryapp.domain.repository.DishRepository
import com.example.deliveryapp.domain.repository.DishesChoiceRepository
import com.example.deliveryapp.domain.repository.ImageRepository
import com.example.deliveryapp.domain.repository.UserRepository
import com.example.deliveryapp.domain.use_cases.ChoiceDishesUseCase
import com.example.deliveryapp.domain.use_cases.ImagesUseCase
import com.example.deliveryapp.domain.use_cases.LocalDishesUseCase
import com.example.deliveryapp.domain.use_cases.RegistrationUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideChoiceDishesUseCase(dishesChoiceRepository: DishesChoiceRepository) =
        ChoiceDishesUseCase(dishesChoiceRepository = dishesChoiceRepository)

    @Provides
    fun provideImagesUseCase(imageRepository: ImageRepository) =
        ImagesUseCase(imageRepository = imageRepository)

    @Provides
    fun provideLocalDishesUseCase(dishRepository: DishRepository) =
        LocalDishesUseCase(dishRepository = dishRepository)

    @Provides
    fun provideRegistrationUseCase(userRepository: UserRepository) =
        RegistrationUseCase(userRepository = userRepository)
}