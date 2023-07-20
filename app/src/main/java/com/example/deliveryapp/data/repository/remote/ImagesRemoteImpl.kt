package com.example.deliveryapp.data.repository.remote

import com.example.deliveryapp.data.remote.api.PixelsApi
import com.example.deliveryapp.data.remote.dto.ImagesResponseDto
import javax.inject.Inject

class ImagesRemoteImpl @Inject constructor(
    private val pixelsApi: PixelsApi
) : ImagesRemote{
    override suspend fun getImages(category: String): ImagesResponseDto =
        pixelsApi.getImages(category = category)
}