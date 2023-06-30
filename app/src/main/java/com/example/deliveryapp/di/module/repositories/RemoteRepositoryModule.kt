package com.example.deliveryapp.di.module.repositories

import com.example.deliveryapp.data.repository.remote.DishesRemote
import com.example.deliveryapp.data.repository.remote.DishesRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteRepositoryModule {

    @Provides
    fun provideDishesRemote(): DishesRemote = DishesRemoteImpl()
}