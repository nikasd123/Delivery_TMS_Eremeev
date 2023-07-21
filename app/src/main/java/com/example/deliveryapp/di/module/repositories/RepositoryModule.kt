package com.example.deliveryapp.di.module.repositories

import com.example.deliveryapp.data.repository.DishesChoiceRepositoryImpl
import com.example.deliveryapp.data.repository.DishesRepositoryImpl
import com.example.deliveryapp.data.repository.ImagesRepositoryImpl
import com.example.deliveryapp.data.repository.UserRepositoryImpl
import com.example.deliveryapp.data.repository.local.ChoiceDishes
import com.example.deliveryapp.data.repository.local.DishesLocal
import com.example.deliveryapp.data.repository.local.UserLocal
import com.example.deliveryapp.data.repository.remote.ImagesRemote
import com.example.deliveryapp.domain.repository.DishRepository
import com.example.deliveryapp.domain.repository.DishesChoiceRepository
import com.example.deliveryapp.domain.repository.ImageRepository
import com.example.deliveryapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideChoiceDishesRepository(choiceDishes: ChoiceDishes): DishesChoiceRepository =
        DishesChoiceRepositoryImpl(choiceDishes = choiceDishes)

    @Provides
    fun provideImageRepository(imagesRemote: ImagesRemote): ImageRepository =
        ImagesRepositoryImpl(imagesRemote = imagesRemote)

    @Provides
    fun provideDishesRepository(dishesLocal: DishesLocal): DishRepository =
        DishesRepositoryImpl(dishesLocal = dishesLocal)

    @Provides
    fun provideUserRepository(userLocal: UserLocal): UserRepository =
        UserRepositoryImpl(userLocal = userLocal)
}