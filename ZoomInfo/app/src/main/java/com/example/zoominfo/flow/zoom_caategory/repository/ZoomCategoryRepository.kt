package com.example.zoominfo.flow.zoom_caategory.repository

import com.example.zoominfo.api.interfaces.IApi
import com.example.zoominfo.api.response.ZoomCategoryInfoItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ZoomCategoryRepository(private val api: IApi?) {
    suspend fun fetchZoomCategory(): List<ZoomCategoryInfoItem>? = withContext(Dispatchers.IO) {
        api?.fetchCategoryInfo()?.let { response ->
            if (!response.isSuccessful) {
                return@withContext null
            }

            response.body()?.result?.results?.let { zoomCategoryInfoItems ->
                val newCategoryInfoItems = mutableListOf<ZoomCategoryInfoItem>()

                zoomCategoryInfoItems.forEach { oldItem ->
                    newCategoryInfoItems.add(oldItem.copyWith(newPicURL = oldItem.ePicURL.replace("http", "https")))
                }

                return@withContext newCategoryInfoItems
            }

            return@withContext null
        }
    }
}