package com.kelly.requestapp.api

import com.kelly.requestapp.models.Item
import com.kelly.requestapp.models.Student
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRequests {

    @GET("items")
    suspend fun getItems(): List<Item>

    @POST("students")
    suspend fun addStudents(@Body newStudent: Student): List<Student>
}