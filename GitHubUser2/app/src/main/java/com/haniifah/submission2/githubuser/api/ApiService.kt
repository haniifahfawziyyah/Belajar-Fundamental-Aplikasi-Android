package com.haniifah.submission2.githubuser.api

import com.haniifah.submission2.githubuser.data.model.DetailUserResponse
import com.haniifah.submission2.githubuser.data.model.User
import com.haniifah.submission2.githubuser.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUserDetail(
        @Path("username") username: String
    ): Call<DetailUserResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<User>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<User>>
}