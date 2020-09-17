package com.example.login.Retrifit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConnectRetrofit {
    fun retrofitService():RetrofitService = retrofit.create(RetrofitService::class.java)

    // Original server
    // private val retrofit = Retrofit.Builder().baseUrl("http://1.229.74.121:8081").addConverterFactory(GsonConverterFactory.create()).build()

    // temporary server
    private val retrofit = Retrofit.Builder().baseUrl("http://192.168.0.7:8081").addConverterFactory(GsonConverterFactory.create()).build()
}