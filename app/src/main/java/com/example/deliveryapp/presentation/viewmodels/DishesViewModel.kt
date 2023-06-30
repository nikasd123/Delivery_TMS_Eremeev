package com.example.deliveryapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryapp.domain.models.DomainDishesList
import com.example.deliveryapp.domain.use_cases.DishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val dishesUseCase: DishesUseCase
) : ViewModel() {
    private val _dishesList = MutableLiveData<DomainDishesList>()
    val dishesList: LiveData<DomainDishesList> = _dishesList

    init {
        getDishes()
    }

    private fun getDishes() {
        _dishesList.value = dishesUseCase.getDishes()
    }
}