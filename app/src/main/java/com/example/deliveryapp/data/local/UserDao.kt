package com.example.deliveryapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE login = :login")
    suspend fun getUserByLogin(login: String): UserEntity?
}
