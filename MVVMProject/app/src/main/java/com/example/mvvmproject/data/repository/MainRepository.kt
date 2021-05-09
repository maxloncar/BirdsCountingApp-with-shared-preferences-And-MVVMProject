package com.example.mvvmproject.data.repository

import com.example.mvvmproject.data.api.ApiHelper
import com.example.mvvmproject.data.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}