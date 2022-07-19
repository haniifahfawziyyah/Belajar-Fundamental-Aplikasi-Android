package com.haniifah.submission2.githubuser.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.haniifah.submission2.githubuser.api.ApiConfig
import com.haniifah.submission2.githubuser.data.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersViewModel: ViewModel() {

    companion object {
        private const val TAG = "Followers"
    }

    val listFollowers = MutableLiveData<ArrayList<User>>()

    fun setListFollowers(username: String) {
        ApiConfig.getApiService()
            .getFollowers(username)
            .enqueue(object : Callback<ArrayList<User>> {
                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>
                ) {
                    if (response.isSuccessful) {
                        listFollowers.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}")
                }

            })
    }

    fun getListFollowers(): LiveData<ArrayList<User>> {
        return listFollowers
    }
}