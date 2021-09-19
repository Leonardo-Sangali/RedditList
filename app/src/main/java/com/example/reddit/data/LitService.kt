package com.example.reddit.data

import com.example.reddit.data.model.ListModel
import retrofit2.Call
import retrofit2.http.GET

interface LitService {

    @GET("/r/androiddev.json?raw_json=1")
    fun list(): Call<ListModel>
}