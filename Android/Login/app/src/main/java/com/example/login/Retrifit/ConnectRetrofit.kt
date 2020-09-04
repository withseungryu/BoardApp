package com.example.login.Retrifit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConnectRetrofit {
    fun retrofitService():RetrofitService = retrofit.create(RetrofitService::class.java)

    private val retrofit = Retrofit.Builder().baseUrl("http://192.168.0.4:8000").addConverterFactory(GsonConverterFactory.create()).build()

}