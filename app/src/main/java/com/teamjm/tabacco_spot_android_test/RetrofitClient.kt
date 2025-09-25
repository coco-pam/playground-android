package com.teamjm.tabacco_spot_android_test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://localhost:8080/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL) // 기본 URL 설정
            .addConverterFactory(GsonConverterFactory.create()) // Gson 변환기 사용
            .build()

        retrofit.create(ApiService::class.java)
    }
}