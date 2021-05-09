package com.example.mvvmproject.data.api

import com.example.mvvmproject.data.model.User
import io.reactivex.Single

interface ApiService {
    fun getUsers(): Single<List<User>>
}