package com.azer.core.repository

import androidx.lifecycle.LiveData
import com.azer.core.model.Message
import com.azer.core.model.Result
import com.azer.core.model.User
import com.azer.core.param.LoginParam
import com.azer.core.vo.Listing

interface AuthRepository {

    suspend fun login(param: LoginParam): LiveData<Result<User>>

    suspend fun loginDB(param: LoginParam) : LiveData<Result<User>>

    suspend fun message(page: Int = 1): Listing<Message>

    suspend fun messageDB() : Listing<Message>
}