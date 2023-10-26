package com.example.zoominfo.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
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
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(OkHttpClient.create())
                .build()
            sUrlRetroMap[baseUrl] = retrofit
        }
        return sUrlRetroMap[baseUrl]?.create(apiInterfaceClz)
    }
}