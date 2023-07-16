package com.example.deliveryapp.domain.models

data class DomainChoiceDishes(
    val imageId: Int,
    val imageLogoId: Int,
    val title: String,
    val category: String = title
)
