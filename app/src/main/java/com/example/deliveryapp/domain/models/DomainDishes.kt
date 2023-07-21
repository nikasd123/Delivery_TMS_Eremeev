package com.example.deliveryapp.domain.models

data class DomainDishes(
    val id: Long?,
    val url: String?,
    val name: String?
) {
    companion object{
        fun empty():DomainDishes = DomainDishes(
            id = 0,
            url = "",
            name = ""
        )
    }
}
