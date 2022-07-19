package com.haniifah.submission2.githubuser.data.model

data class UserResponse(
    var items: ArrayList<User>,
    val incomplete_result: Boolean
)
