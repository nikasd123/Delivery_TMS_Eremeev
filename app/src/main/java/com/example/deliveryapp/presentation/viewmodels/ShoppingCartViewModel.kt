package com.example.deliveryapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryapp.domain.models.DomainDishes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoppingCartViewModel @Inject constructor() : ViewModel() {
    private val _cartItems = MutableLiveData<List<DomainDishes>>()
    val cartItems: LiveData<List<DomainDishes>> = _cartItems

    fun addToCart(dish: DomainDishes) {
        val currentItems = _cartItems.value.orEmpty().toMutableList()
        currentItems.add(dish)

        _cartItems.value = currentItems
    }
}