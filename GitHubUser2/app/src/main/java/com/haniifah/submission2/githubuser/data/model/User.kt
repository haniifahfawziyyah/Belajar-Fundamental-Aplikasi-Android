package com.haniifah.submission2.githubuser.data.model

data class User(
    val login: String,
    val id: Int,
    val avatar_url: String,
    val name: String,
    val incomplete_result: Boolean
)