package com.example.deliveryapp.data.repository.local

import com.example.deliveryapp.R
import com.example.deliveryapp.data.remote.dto.DataDishesDto

class ChoiceDishesImpl : ChoiceDishes {
    override fun getChoiceDishes(): List<DataDishesDto> =
        mutableListOf(
            DataDishesDto(
                imageId = R.drawable.pizza_background,
                imageLogoId = R.drawable.pizza,
                title = "PIZZA"
            ),
            DataDishesDto(
                imageId = R.drawable.sushi_background,
                imageLogoId = R.drawable.sushi,
                title = "SUSHI"
            ),
            DataDishesDto(
                imageId = R.drawable.drinks_background,
                imageLogoId = R.drawable.cocktail,
                title = "DRINKS"
            )
        )
}