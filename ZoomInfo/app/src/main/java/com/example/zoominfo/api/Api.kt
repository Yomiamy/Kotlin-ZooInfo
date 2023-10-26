package com.example.zoominfo.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.ConcurrentHashMap

object Api {

    private val sUrlRetroMap = ConcurrentHashMap<String, Retrofit>()

    fun <InterfaceTypeClz> getInstance(
        baseUrl: String,
        apiInterfaceClz: Class<InterfaceTypeClz>
    ): InterfaceTypeClz? {
        if (!sUrlRetroMap.contains(baseUrl)) {
            val gson: Gson = GsonBuilder().setLenient().create()

            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpClient.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            sUrlRetroMap[baseUrl] = retrofit
        }
        return sUrlRetroMap[baseUrl]?.create(apiInterfaceClz)
    }
}