package com.example.deliveryapp.di.module

import com.example.deliveryapp.domain.repository.DishesRepository
import com.example.deliveryapp.domain.use_cases.DishesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideDishesUseCase(dishesRepository: DishesRepository) =
        DishesUseCase(dishesRepository = dishesRepository)
}