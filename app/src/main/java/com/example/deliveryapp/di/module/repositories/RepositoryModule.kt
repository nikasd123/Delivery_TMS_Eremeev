package com.example.deliveryapp.di.module.repositories

import com.example.deliveryapp.data.repository.DishesChoiceRepositoryImpl
import com.example.deliveryapp.data.repository.ImagesRepositoryImpl
import com.example.deliveryapp.data.repository.local.DishesLocal
import com.example.deliveryapp.data.repository.remote.ImagesRemote
import com.example.deliveryapp.data.repository.remote.ImagesRemoteImpl
import com.example.deliveryapp.domain.repository.DishesChoiceRepository
import com.example.deliveryapp.domain.repository.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideDishesRepository(dishesLocal: DishesLocal): DishesChoiceRepository =
        DishesChoiceRepositoryImpl(dishesLocal = dishesLocal)

    @Provides
    fun provideImageRepository(imagesRemote: ImagesRemote): ImageRepository =
        ImagesRepositoryImpl(imagesRemote = imagesRemote)
}