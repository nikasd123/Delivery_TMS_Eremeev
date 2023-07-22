package com.example.deliveryapp.data.remote.api

import com.example.deliveryapp.BuildConfig
import com.example.deliveryapp.data.remote.dto.ImagesResponseDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface PixelsApi {
    companion object {
        const val GET_IMAGES_REQUEST = "search"
        const val CATEGORY_PARAM = "query"
        const val API_KEY_PARAM = "Authorization"
        const val API_KEY = BuildConfig.API_KEY
    }

    @Headers("$API_KEY_PARAM: $API_KEY")
    @GET(GET_IMAGES_REQUEST)
    suspend fun getDishesImages(
        @Query(CATEGORY_PARAM) category: String
    ): ImagesResponseDto
}


