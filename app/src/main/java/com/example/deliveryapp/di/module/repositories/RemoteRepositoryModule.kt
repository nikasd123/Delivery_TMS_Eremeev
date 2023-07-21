package com.example.deliveryapp.di.module.repositories

import com.example.deliveryapp.data.remote.api.PixelsApi
import com.example.deliveryapp.data.repository.remote.ImagesRemote
import com.example.deliveryapp.data.repository.remote.ImagesRemoteImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class RemoteRepositoryModule {

    @Provides
    fun provideImagesRemote(pixelsApi: PixelsApi): ImagesRemote =
        ImagesRemoteImpl(pixelsApi = pixelsApi)
}
