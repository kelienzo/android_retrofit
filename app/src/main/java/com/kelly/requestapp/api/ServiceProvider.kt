package com.kelly.requestapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ServiceProvider {
    private val retrofit = Retrofit.Builder().baseUrl("https://ict-yep-backend.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val placeHolderApi = retrofit.create(PlaceHolderApi::class.java)
}