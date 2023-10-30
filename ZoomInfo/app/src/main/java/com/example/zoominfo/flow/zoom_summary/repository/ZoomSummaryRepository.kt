package com.example.zoominfo.flow.zoom_summary.repository

import com.example.zoominfo.api.interfaces.IApi
import com.example.zoominfo.api.response.ZoomInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ZoomSummaryRepository(private val api: IApi?) {

    private var mAllZoomList: MutableList<ZoomInfo> = mutableListOf()

    suspend fun fetchAllZoomList(): List<ZoomInfo>? = withContext(Dispatchers.IO) {
        // 使用既有緩存
        if (!mAllZoomList.isNullOrEmpty()) {
            return@withContext mAllZoomList
        }

        api?.fetchAllZoomInfo()?.let { response ->
            if (!response.isSuccessful) {
                return@withContext null
            }

            response.body()?.result?.results?.let { zoomInfoList ->
                zoomInfoList.forEach { zoomInfo ->
                    val newPic01URL = zoomInfo.aPic01URL.replace("http", "https")
                    val newPic02URL = zoomInfo.aPic02URL.replace("http", "https")
                    val newPic03URL = zoomInfo.aPic03URL.replace("http", "https")
                    val newPic04URL = zoomInfo.aPic04URL.replace("http", "https")

                    val newZoomInfo = zoomInfo.copyWith(
                        newPic01URL = newPic01URL,
                        newPic02URL = newPic02URL,
                        newPic03URL = newPic03URL,
                        newPic04URL = newPic04URL
                    )
                    mAllZoomList.add(newZoomInfo)
                }
                return@withContext mAllZoomList
            }

            return@withContext null
        }
    }
}