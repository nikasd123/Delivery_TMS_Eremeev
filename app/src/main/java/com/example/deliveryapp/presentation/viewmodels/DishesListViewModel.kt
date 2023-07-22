package com.example.deliveryapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.domain.models.DomainDishes
import com.example.deliveryapp.domain.use_cases.ImagesUseCase
import com.example.deliveryapp.domain.use_cases.LocalDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishesListViewModel @Inject constructor(
    private val imagesUseCase: ImagesUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val dishesUseCase: LocalDishesUseCase
) : ViewModel() {
    private val _imagesList = MutableLiveData<List<DomainDishes>>()
    val imagesList: LiveData<List<DomainDishes>> = _imagesList

    init {
        viewModelScope.launch {
            getImages()
        }
    }

    private suspend fun getImages() {
        val category = savedStateHandle.getLiveData<String>("category").value

        _imagesList.value = category.let { categoryValue ->
            categoryValue?.let { dishCategory ->
                imagesUseCase.getImages(dishCategory)
            }
        }
    }

    fun addSelectedDishToCart(dish: DomainDishes) {
        viewModelScope.launch {
            dishesUseCase.addDish(dish)
        }
    }

    fun getImagesByCategory(category: String) {
        viewModelScope.launch {
            _imagesList.value = imagesUseCase.getImages(category)
        }
    }
}