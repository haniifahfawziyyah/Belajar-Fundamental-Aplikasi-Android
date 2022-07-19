package com.haniifah.submission3.githubuser.data.model

data class UserResponse(
    var items: ArrayList<User>,
    val incomplete_result: Boolean
)