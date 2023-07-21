package com.example.deliveryapp.presentation

import com.example.deliveryapp.domain.models.DomainDishes

interface OnDishItemClickListener {
    fun onDishClicked(dish: DomainDishes)
}