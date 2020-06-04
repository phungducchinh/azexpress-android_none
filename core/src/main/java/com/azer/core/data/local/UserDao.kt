package com.azer.core.data.local

import androidx.room.Dao
import androidx.room.Query
import com.azer.core.model.User

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT * FROM User")
    suspend fun getUser(): List<User>

    @Query("SELECT * FROM User WHERE email LIKE :email")
    suspend fun findUser(email : String?) : User?
}