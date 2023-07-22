package com.example.deliveryapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.domain.use_cases.RegistrationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val registrationUseCase: RegistrationUseCase
) : ViewModel() {
    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    fun registerUser(login: String, password: String) {
        viewModelScope.launch {
            registrationUseCase.registerUserIfNotExists(login, password)
            _isLoggedIn.value = true
        }
    }
}