package com.azer.core.api

import com.azer.core.model.ObjectResponse
import com.azer.core.model.ListResponse
import com.azer.core.model.Message
import com.azer.core.model.User
import com.azer.core.param.LoginParam
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("users-login")
    suspend fun login(@Body login: LoginParam): Response<ObjectResponse<User>>

    @GET("search-user")
    suspend fun getMessage(
        @Query("page") page: Int = 1,
        @Query("current_per_page") perPage: Int = 15
    ): Response<ListResponse<Message>>
}