package com.example.deliveryapp.di.module.repositories

import com.example.deliveryapp.data.repository.local.DishesLocal
import com.example.deliveryapp.data.repository.local.DishesLocalImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalRepositoryModule {

    @Provides
    fun provideDishesLocal(): DishesLocal = DishesLocalImpl()
}