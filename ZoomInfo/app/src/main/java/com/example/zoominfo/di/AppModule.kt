package com.example.zoominfo.di

import com.example.zoominfo.api.Api
import com.example.zoominfo.api.interfaces.IApi
import com.example.zoominfo.flow.zoom_caategory.repository.ZoomCategoryRepository
import com.example.zoominfo.utils.GlobalConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideApi(): IApi? {
        return Api.getInstance(GlobalConfig.BASE_API_URL, IApi::class.java)
    }
}