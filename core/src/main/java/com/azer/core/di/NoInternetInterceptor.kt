package com.azer.core.di

import com.azer.core.CoreApplication
import com.azer.core.util.AppEvent
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NoInternetInterceptor(val app: CoreApplication): Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!app.isNetworkConnected()) {
            AppEvent.onNoInternet()
            throw IOException("NO connected internet")
        }
        val request = chain.request()
        return chain.proceed(request.newBuilder().build())
    }

}