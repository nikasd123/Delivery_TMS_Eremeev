package com.example.deliveryapp.data.remote.api

import com.example.deliveryapp.BuildConfig
import com.example.deliveryapp.data.remote.dto.ResponseDto
import com.google.gson.internal.GsonBuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.Properties


interface PixelsApi {
    companion object {
        const val GET_IMAGES_REQUEST = "search"
        const val CATEGORY_PARAM = "query"
        const val API_KEY_PARAM = "Authorization"
        const val API_KEY = BuildConfig.API_KEY
    }

    @Headers("$API_KEY_PARAM: $API_KEY")
    @GET(GET_IMAGES_REQUEST)
    suspend fun getImages(
        @Query(CATEGORY_PARAM) category: String
    ): ResponseDto
}


