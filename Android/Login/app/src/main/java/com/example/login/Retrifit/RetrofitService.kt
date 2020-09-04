package com.example.login.Retrifit

import com.example.login.Board.Board
import com.example.login.Login.Login
import com.example.login.Register.Register
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {

    //게시판 불러오기
    @GET("/api/boards/")
    fun requestSearchBoard(
    ):Call<Board>

    //로그인 요청
    @FormUrlEncoded
    @POST("/app_login/")
    fun requestLogin(
        //인풋을 정의 하는곳
        @Field("userId") userId:String,
        @Field("userPassword") userPassword:String
    ): Call<Login>//아웃풋을 정의 하는곳

    //회원가입 요청
    @FormUrlEncoded
    @POST("/app_register/")
    fun requestRegister(
        //인풋을 정의 하는곳
        @Field("userId") userId:String,
        @Field("userPassword") userPassword:String,
        @Field("userName") userName:String,
        @Field("userAge") userAge:String
    ): Call<Register>//아웃풋을 정의 하는곳
}