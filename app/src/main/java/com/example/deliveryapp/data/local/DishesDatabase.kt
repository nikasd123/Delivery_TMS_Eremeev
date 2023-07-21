package com.example.deliveryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DishEntity::class], version = 1)
abstract class DishesDatabase : RoomDatabase(){
    abstract fun dishesDao(): DishesDao
}