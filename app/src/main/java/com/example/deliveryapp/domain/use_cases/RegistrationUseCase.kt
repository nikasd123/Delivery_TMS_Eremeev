package com.example.deliveryapp.domain.use_cases

import com.example.deliveryapp.data.local.UserEntity
import com.example.deliveryapp.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegistrationUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend fun registerUserIfNotExists(login: String, password: String) {
        if (!userRepository.isUserExist(login)) {
            val user = UserEntity(login = login, password = password)
            userRepository.insertUser(user)
        }
    }
}