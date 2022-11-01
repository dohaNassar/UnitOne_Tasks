package com.example.unitonetasks.interfaces

import com.example.unitonetasks.models.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("/home/public")
    suspend fun getQuotes() : Response<ApiResponse>
}