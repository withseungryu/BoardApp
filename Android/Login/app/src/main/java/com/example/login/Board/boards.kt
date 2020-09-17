package com.example.login.Board

import com.google.gson.annotations.SerializedName

data class boards(

    @SerializedName("title")
    var title:String,
    @SerializedName("subTitle")
    var subTitle:String,
    @SerializedName("content")
    var content:String,
    @SerializedName("createdDate")
    var createdDate:String,
    @SerializedName("updatedDate")
    var updatedDate:String

)