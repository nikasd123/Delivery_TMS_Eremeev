package com.example.deliveryapp

import com.example.deliveryapp.data.local.DishEntity
import com.example.deliveryapp.data.local.UserEntity
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.domain.repository.DishRepository
import com.example.deliveryapp.domain.repository.UserRepository
import com.example.deliveryapp.domain.use_cases.LocalDishesUseCase
import com.example.deliveryapp.domain.use_cases.RegistrationUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner::class)
class RegistrationUseCaseTest {

    @Mock
    private lateinit var userRepository: UserRepository
    private lateinit var registrationUseCase: RegistrationUseCase

    @Before
    fun setUp() {
        registrationUseCase = RegistrationUseCase(userRepository)
    }

    @Test
    fun testRegisterUserIfNotExistsSuccess() {
        runBlocking {
            val login = "testUser"
            val password = "testPassword"

            // Устанавливаем заглушку для метода isUserExists
            `when`(userRepository.isUserExist(login)).thenReturn(false)

            // Вызываем метод регистрации
            registrationUseCase.registerUserIfNotExists(login, password)

            // Проверяем, что пользователь был добавлен
            verify(userRepository).insertUser(UserEntity(login = login, password = password))
        }
    }

    @Test
    fun testRegisterUserIfNotExistsError() {
        runBlocking {
            val login = "testUser"
            val password = "testPassword"

            // Устанавливаем заглушку для метода isUserExists
            `when`(userRepository.isUserExist(login)).thenReturn(true)

            // Вызываем метод регистрации
            registrationUseCase.registerUserIfNotExists(login, password)

            // Проверяем, что пользователь не был добавлен
            verify(userRepository, never()).insertUser(
                UserEntity(
                    login = login,
                    password = password
                )
            )
        }
    }
}

@RunWith(MockitoJUnitRunner::class)
class LocalDishesUseCaseTest {

    @Mock
    private lateinit var dishRepository: DishRepository

    private lateinit var localDishesUseCase: LocalDishesUseCase

    @Before
    fun setUp() {
        localDishesUseCase = LocalDishesUseCase(dishRepository)
    }

    @Test
    fun testGetSavedDishes() {
        runBlocking {
            // Create mocs of DomainDishes and DishEntity objects
            val domainDish1 = DomainDishes(id = 1, url = "url1", name = "dish1")
            val domainDish2 = DomainDishes(id = 2, url = "url2", name = "dish2")
            val domainDish3 = DomainDishes(id = 3, url = "url3", name = "dish3")

            val dishEntity1 = DishEntity(id = 1, url = "url1", name = "dish1")
            val dishEntity2 = DishEntity(id = 2, url = "url2", name = "dish2")
            val dishEntity3 = DishEntity(id = 3, url = "url3", name = "dish3")

            // Устанавливаем заглушку для метода getSavedDishes в репозитории
            `when`(dishRepository.getSavedDishes()).thenReturn(
                listOf(
                    dishEntity1,
                    dishEntity2,
                    dishEntity3
                )
            )

            // Вызываем метод getSavedDishes в use case
            val result = runBlocking { localDishesUseCase.getSavedDishes() }

            // Проверяем, что список, возвращенный из use case, содержит правильные данные
            assertEquals(listOf(domainDish1, domainDish2, domainDish3), result)
        }
    }


    @Test
    fun testAddDish() {
        runBlocking {
            // Создаем мок объекта DomainDishes
            val domainDish = DomainDishes(id = 1, url = "url1", name = "dish1")

            // Вызываем метод addDish в use case
            runBlocking { localDishesUseCase.addDish(domainDish) }

            // Проверяем, что метод addDish в репозитории был вызван с правильным параметром
            verify(dishRepository).addDish(DishEntity(id = 1, url = "url1", name = "dish1"))
        }
    }

    @Test
    fun testRemoveDish() {
        runBlocking {
            // Создаем мок объекта DomainDishes
            val domainDish = DomainDishes(id = 1, url = "url1", name = "dish1")

            // Вызываем метод removeDish в use case
            runBlocking { localDishesUseCase.removeDish(domainDish) }

            // Проверяем, что метод removeDish в репозитории был вызван с правильным параметром
            verify(dishRepository).removeDish(DishEntity(id = 1, url = "url1", name = "dish1"))
        }
    }
}

