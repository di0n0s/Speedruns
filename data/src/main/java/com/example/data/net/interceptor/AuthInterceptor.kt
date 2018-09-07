package com.example.data.net.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor() : Interceptor{

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println("URL -> " + request?.url())
        return chain.proceed(request)
    }
}