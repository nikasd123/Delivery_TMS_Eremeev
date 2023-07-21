package com.example.deliveryapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DishesDao {
    @Query("SELECT * FROM dishes")
    suspend fun getAllDishes(): List<DishEntity>//

    @Query("SELECT * FROM dishes WHERE id = :dishId")
    suspend fun getDishById(dishId: Long): DishEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDish(dishEntity: DishEntity?)

    @Update
    suspend fun updateDish(dishEntity: DishEntity?)

    @Delete
    suspend fun deleteDish(dishEntity: DishEntity?)
}