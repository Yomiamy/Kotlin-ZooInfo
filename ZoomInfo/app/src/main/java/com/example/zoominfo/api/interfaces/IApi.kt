package com.example.zoominfo.api.interfaces

import com.example.zoominfo.api.response.ZoomCategoryInfo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface IApi {

    @GET("/api/v1/dataset/5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a?scope=resourceAquire")
    suspend fun fetchCategoryInfo(): Response<ZoomCategoryInfo>
}