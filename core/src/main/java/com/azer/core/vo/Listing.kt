package com.azer.core.vo

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.azer.core.model.Result

data class Listing<T>(
    // the LiveData of paged lists for the UI to observe
    val result: LiveData<PagedList<T>>,
    val status: LiveData<Result<T>>,
    // represents the network request status to show to the user
    val refresh: () -> Unit
    // retries any failed requests.
)
