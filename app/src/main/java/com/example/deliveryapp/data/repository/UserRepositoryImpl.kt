package com.example.deliveryapp.data.repository

import com.example.deliveryapp.data.local.UserEntity
import com.example.deliveryapp.data.repository.local.UserLocal
import com.example.deliveryapp.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userLocal: UserLocal
): UserRepository{
    override suspend fun insertUser(user: UserEntity) {
        userLocal.insertUser(user)
    }

    override suspend fun isUserExist(login: String): Boolean =
        userLocal.getUserByLogin(login) != null

    override suspend fun getUserByLogin(login: String): UserEntity? =
        userLocal.getUserByLogin(login)
}