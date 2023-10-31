package com.example.zoominfo.di

import com.example.zoominfo.api.interfaces.IApi
import com.example.zoominfo.flow.zoom_caategory.repository.ZooCategoryRepository
import com.example.zoominfo.flow.zoom_summary.repository.ZooSummaryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    fun provideZoomCategoryRepository(api: IApi?): ZooCategoryRepository {
        return ZooCategoryRepository(api)
    }

    @Provides
    fun provideZoomSummaryRepository(api: IApi?): ZooSummaryRepository {
        return ZooSummaryRepository(api)
    }
}