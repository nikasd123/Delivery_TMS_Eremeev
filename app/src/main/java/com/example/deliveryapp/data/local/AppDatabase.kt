package com.example.deliveryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DishEntity::class, UserEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase(){
    abstract fun dishesDao(): DishesDao
    abstract fun userDao(): UserDao
}