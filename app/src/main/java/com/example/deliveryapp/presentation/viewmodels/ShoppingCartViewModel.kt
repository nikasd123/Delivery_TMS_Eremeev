package com.example.deliveryapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.domain.use_cases.LocalDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingCartViewModel @Inject constructor(
    private val dishesUseCase: LocalDishesUseCase
) : ViewModel() {
    private val _cartItems = MutableLiveData<List<DomainDishes>?>()
    val cartItems: MutableLiveData<List<DomainDishes>?> = _cartItems

    init {
        loadCartItems()
    }

    private fun loadCartItems() {
        viewModelScope.launch {
            val cartItemsList = dishesUseCase.getSavedDishes()
            _cartItems.value = cartItemsList
        }
    }

    fun isShoppingCartEmpty(): Boolean = cartItems.value.isNullOrEmpty()

    fun removeDishFromCart(dish: DomainDishes) {
        viewModelScope.launch {
            dishesUseCase.removeDish(dish)
            _cartItems.value = _cartItems.value?.filter { domainDishes ->
                domainDishes.id != dish.id
            }
        }
    }
}