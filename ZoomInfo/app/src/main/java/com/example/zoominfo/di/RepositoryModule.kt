package com.example.zoominfo.di

import com.example.zoominfo.api.interfaces.IApi
import com.example.zoominfo.flow.zoom_caategory.repository.ZoomCategoryRepository
import com.example.zoominfo.flow.zoom_caategory.viewmodel.ZoomCategoryViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideZoomCategoryRepository(api: IApi?): ZoomCategoryRepository {
        return ZoomCategoryRepository(api)
    }
}