package com.example.deliveryapp.di.module.repositories

import com.example.deliveryapp.data.local.DishesDao
import com.example.deliveryapp.data.repository.local.ChoiceDishes
import com.example.deliveryapp.data.repository.local.ChoiceDishesImpl
import com.example.deliveryapp.data.repository.local.DishLocalImpl
import com.example.deliveryapp.data.repository.local.DishesLocal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalRepositoryModule {

    @Provides
    fun provideChoiceDishesLocal(): ChoiceDishes = ChoiceDishesImpl()

    @Provides
    fun provideDishesLocal(dishesDao: DishesDao): DishesLocal =
        DishLocalImpl(dishesDao = dishesDao)
}