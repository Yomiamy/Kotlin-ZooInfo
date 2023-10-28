package com.example.zoominfo.api.response

import com.google.gson.annotations.SerializedName


data class AllZoomInfo (
    val result: AllZoomInfoResult
)

data class AllZoomInfoResult (
    @SerializedName("limit")
    val limit: Long,
    @SerializedName("offset")
    val offset: Long,
    @SerializedName("count")
    val count: Long,
    @SerializedName("sort")
    val sort: String,
    @SerializedName("results")
    val results: List<ZoomInfo>
)

data class ZoomInfo (
    @SerializedName("_id")
    val id: Long,
    @SerializedName("a_name_ch")
    val aNameCh: String,
    @SerializedName("a_name_en")
    val aNameEn: String,
    @SerializedName("a_summary")
    val aSummary: String,
    @SerializedName("a_alsoknown")
    val aAlsoknown: String,
    @SerializedName("a_location")
    val aLocation: String,
    @SerializedName("a_phylum")
    val aPhylum: String,
    @SerializedName("a_class")
    val aClass: String,
    @SerializedName("a_order")
    val aOrder: String,
    @SerializedName("a_family")
    val aFamily: String,
    @SerializedName("a_conservation")
    val aConservation: String,
    @SerializedName("a_distribution")
    val aDistribution: String,
    @SerializedName("a_habitat")
    val aHabitat: String,
    @SerializedName("a_feature")
    val aFeature: String,
    @SerializedName("a_behavior")
    val aBehavior: String,
    @SerializedName("a_diet")
    val aDiet: String,
    @SerializedName("a_crisis")
    val aCrisis: String,
    @SerializedName("a_pic01_alt")
    val aPic01Alt: String,
    @SerializedName("a_pic01_url")
    val aPic01URL: String,
    @SerializedName("a_pic02_alt")
    val aPic02Alt: String,
    @SerializedName("a_pic02_url")
    val aPic02URL: String,
    @SerializedName("a_pic03_alt")
    val aPic03Alt: String,
    @SerializedName("a_pic03_url")
    val aPic03URL: String,
    @SerializedName("a_pic04_alt")
    val aPic04Alt: String,
    @SerializedName("a_pic04_url")
    val aPic04URL: String,
    @SerializedName("a_vedio_url")
    val aVedioURL: String,
    @SerializedName("a_update")
    val aUpdate: String
) {
    fun copyWith(
        newId: Long = id,
        neweNameCh: String = aNameCh,
        neweNameEn: String = aNameEn,
        neweSummary: String = aSummary,
        neweAlsoknown: String = aAlsoknown,
        newLocation: String = aLocation,
        newPhylum: String = aPhylum,
        newClass: String = aClass,
        newOrder: String = aOrder,
        newFamily: String = aFamily,
        newConservation: String = aConservation,
        newDistribution: String = aDistribution,
        newHabitat: String = aHabitat,
        newFeature: String = aFeature,
        neweBehavior: String = aBehavior,
        newDiet: String = aDiet,
        newCrisis: String = aCrisis,
        newPic01Alt: String = aPic01Alt,
        newPic01URL: String = aPic01URL,
        newPic02Alt: String = aPic02Alt,
        newPic02URL: String = aPic02URL,
        newPic03Alt: String = aPic03Alt,
        newPic03URL: String = aPic03URL,
        newPic04Alt: String = aPic04Alt,
        newPic04URL: String = aPic04URL,
        newVedioURL: String = aVedioURL                                                ,
        newUpdate: String = aUpdate
    ): ZoomInfo {
        return ZoomInfo(newId
            , neweNameCh
            , neweSummary
            , neweAlsoknown
            , newLocation
            , newPhylum
            , newClass
            , newOrder
            , newFamily
            , newConservation
            , newDistribution
            , newHabitat
            , newFeature
            , neweBehavior
            , newDiet
            , newCrisis
            , newPic01Alt
            , newPic01URL
            , newPic02Alt
            , newPic02URL
            , newPic03Alt
            , newPic03URL
            , newPic04Alt
            , newPic04URL
            , newVedioURL
            , newUpdate)
    }
}
