package com.example.login.Board

import com.google.gson.annotations.SerializedName


data class board(
    var _embedded: _embedded,
    var _links:_links,
    var page: page
)

data class _embedded(

    var boards: List<boards>

)

data class _links(
    var self:self
)

data class self(
    var href:String
)

data class page(
    @SerializedName("size")
    var size:Int,
    @SerializedName("totalElements")
    var totalElements: Int,
    @SerializedName("totalPages")
    var totalPages: Int,
    @SerializedName("number")
    var number: Int
)
