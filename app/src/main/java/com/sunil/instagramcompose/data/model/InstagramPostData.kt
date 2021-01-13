package com.sunil.instagramcompose.data.model

data class InstagramPostData(
    val id: Int,
    val user: String,
    val time: String,
    val userImageId: Int,
    val likesCount: Int,
    val commentsCount: Int,
    val instagramImageId: Int = 0
)