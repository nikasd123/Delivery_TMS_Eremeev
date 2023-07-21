package com.example.deliveryapp.domain.repository

import com.example.deliveryapp.data.local.UserEntity

interface UserRepository {
    suspend fun insertUser(user: UserEntity)
    suspend fun isUserExist(login: String): Boolean
    suspend fun getUserByLogin(login: String): UserEntity?
}