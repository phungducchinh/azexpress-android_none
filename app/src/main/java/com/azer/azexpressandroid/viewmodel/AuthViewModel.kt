package com.azer.azexpressandroid.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagedList
import com.azer.core.model.Message
import com.azer.core.model.User
import com.azer.core.param.LoginParam
import com.azer.core.repository.AuthRepository
import com.azer.core.model.Result
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel() {

    val loginLiveData = MediatorLiveData<User>()
    val messagesLiveData = MediatorLiveData<PagedList<Message>>()
    val loadStateLiveData = MediatorLiveData<Result<Message>>()

    fun login(param: LoginParam) {
        viewModelScope.launch {
            loginLiveData.addSource(repository.login(param)) {
                when (it) {
                    is Result.Success -> {
                        loginLiveData.value = it.data
                    }
                }
            }
        }
    }

    fun loginDB(param: LoginParam){
        viewModelScope.launch {
            loginLiveData.addSource(repository.loginDB(param)){
                when(it){
                    is Result.Success -> {
                        loginLiveData.value = it.data
                    }
                }
            }
        }
    }

    fun messagePaging() {
        viewModelScope.launch {
            val request = repository.message()

            messagesLiveData.addSource(request.result) {
                messagesLiveData.value = it
            }

            messagesLiveData.addSource(request.status){
               loadStateLiveData.value = it
            }
        }
    }

    fun messagePagingDB() {
        viewModelScope.launch {
            val request = repository.messageDB()

            messagesLiveData.addSource(request.result) {
                messagesLiveData.value = it
            }
        }
    }
}