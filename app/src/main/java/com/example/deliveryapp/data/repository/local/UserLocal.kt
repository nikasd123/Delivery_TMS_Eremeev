package com.example.deliveryapp.data.repository.local

import com.example.deliveryapp.data.local.UserEntity

interface UserLocal {
    suspend fun insertUser(user: UserEntity)
    suspend fun getUserByLogin(login: String): UserEntity?
}