package com.example.deliveryapp.di.module.repositories

import com.example.deliveryapp.data.repository.DishesRepositoryImpl
import com.example.deliveryapp.data.repository.remote.DishesRemote
import com.example.deliveryapp.domain.repository.DishesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideDishesRepository(dishesRemote: DishesRemote): DishesRepository =
        DishesRepositoryImpl(dishesRemote = dishesRemote)
}