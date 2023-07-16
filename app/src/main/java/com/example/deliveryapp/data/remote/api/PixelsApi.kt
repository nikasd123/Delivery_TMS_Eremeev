package com.example.deliveryapp.data.remote.api

import com.example.deliveryapp.data.remote.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface PixelsApi {
    private companion object {
        const val GET_IMAGES_REQUEST = "search"
        const val CATEGORY_PARAM = "query"
        const val API_KEY_PARAM = "Authorization"
        const val API_KEY = "Wy6pUdHfjaqywKlfBXiFOogU5gFYjMjwPRnqi8y9Ko3uaFJRB22J50lL"
    }

    @Headers("$API_KEY_PARAM: $API_KEY")
    @GET(GET_IMAGES_REQUEST)
    suspend fun getImages(
        @Query(CATEGORY_PARAM) category: String
    ): ResponseDto
}


