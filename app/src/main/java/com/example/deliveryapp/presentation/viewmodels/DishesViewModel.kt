package com.example.deliveryapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryapp.domain.models.DomainChoiceDishesList
import com.example.deliveryapp.domain.use_cases.ChoiceDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DishesViewModel @Inject constructor(
    private val choiceDishesUseCase: ChoiceDishesUseCase
) : ViewModel() {
    private val _dishesList = MutableLiveData<DomainChoiceDishesList>()
    val dishesList: LiveData<DomainChoiceDishesList> = _dishesList

    init {
        getDishes()
    }

    private fun getDishes() {
        _dishesList.value = choiceDishesUseCase.getDishes()
    }
}