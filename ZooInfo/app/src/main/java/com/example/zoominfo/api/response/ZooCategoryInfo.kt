package com.example.zoominfo.api.response

import com.google.gson.annotations.SerializedName


data class ZoomCategoryInfo(val result: ZoomCategoryInfoResult)

data class ZoomCategoryInfoResult (
    @SerializedName("limit")
    val limit: Long,
    @SerializedName("offset")
    val offset: Long,
    @SerializedName("count")
    val count: Long,
    @SerializedName("sort")
    val sort: String,
    @SerializedName("results")
    val results: List<ZoomCategoryInfoItem>
)

data class ZoomCategoryInfoItem (
    @SerializedName("_id")
    val id: Long,
    @SerializedName("e_no")
    val eNo: String,
    @SerializedName("e_category")
    val eCategory: String,
    @SerializedName("e_name")
    val eName: String,
    @SerializedName("e_pic_url")
    val ePicURL: String,
    @SerializedName("e_info")
    val eInfo: String,
    @SerializedName("e_memo")
    val eMemo: String,
    @SerializedName("e_geo")
    val eGeo: String,
    @SerializedName("e_url")
    val eURL: String


) {
    override fun equals(other: Any?): Boolean {
        if(other !is ZoomCategoryInfoItem) {
            return false
        }

        return id == other.id
                && eNo == other.eNo
                && eCategory == other.eCategory
                && eName == other.eName
                && ePicURL == other.ePicURL
                && eInfo == other.eInfo
                && eMemo == other.eMemo
                && eGeo == other.eGeo
                && eURL == other.eURL
    }

    fun copyWith(
        newId: Long = id,
        neweNo: String = eNo,
        neweCategory: String = eCategory,
        neweName: String = eName,
        newPicURL: String = ePicURL,
        neweInfo: String = eInfo,
        neweMemo: String = eMemo,
        newGeo: String = eGeo,
        newURL: String = eURL
    ): ZoomCategoryInfoItem {
        return ZoomCategoryInfoItem(newId
            , neweNo
            , neweCategory
            , neweName
            , newPicURL
            , neweInfo
            , neweMemo
            , newGeo
            , newURL)
    }
}