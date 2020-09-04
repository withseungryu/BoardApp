package com.example.login.Board

class BoardRecyclerViewItem {
    var mTitle: String? = null
    var mText: String? = null

    constructor(title:String, text:String) {
        mTitle = title
        mText = text
    }

    override fun toString(): String {
        return "$mTitle\n$mText"
    }
}