package com.example.zoominfo.api.interfaces

import com.example.zoominfo.api.response.AllZoomInfo
import com.example.zoominfo.api.response.ZoomCategoryInfo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface IApi {

    @GET("/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    suspend fun fetchCategoryInfo(): Response<ZoomCategoryInfo>

    @GET("/api/v1/dataset/a3e2b221-75e0-45c1-8f97-75acbd43d613?scope=resourceAquire&limit=1000")
    suspend fun fetchAllZoomInfo(): Response<AllZoomInfo>
}