package com.example.deliveryapp.di.base

import android.content.Context
import androidx.room.Room
import com.example.deliveryapp.data.local.AppDatabase
import com.example.deliveryapp.data.local.DishEntity
import com.example.deliveryapp.data.local.UserEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context
    ): AppDatabase =
        Room.databaseBuilder(
            context, AppDatabase::class.java,
            "dishes_db"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDishDao(database: AppDatabase) = database.dishesDao()

    @Provides
    @Singleton
    fun provideDishEntity() = DishEntity()

    @Provides
    @Singleton
    fun provideUserDao(database: AppDatabase) = database.userDao()

    @Provides
    @Singleton
    fun provideUserEntity() = UserEntity()
}