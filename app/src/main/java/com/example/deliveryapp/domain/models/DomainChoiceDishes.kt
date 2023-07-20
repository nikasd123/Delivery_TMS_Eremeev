package com.example.deliveryapp.domain.models

data class DomainChoiceDishes(
    val imageId: Int,
    val imageLogoId: Int,
    val title: String,
    val category: String = title
) {
    companion object {
        fun empty(): DomainChoiceDishes = DomainChoiceDishes(
            imageId = 0,
            imageLogoId = 0,
            title = ""
        )
    }
}
