package com.example.deliveryapp.data.repository.local

import com.example.deliveryapp.data.local.UserDao
import com.example.deliveryapp.data.local.UserEntity
import javax.inject.Inject

class UserLocalImpl @Inject constructor(
    private val userDao: UserDao
): UserLocal{
    override suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user = user)
    }

    override suspend fun getUserByLogin(login: String): UserEntity? =
        userDao.getUserByLogin(login)
}