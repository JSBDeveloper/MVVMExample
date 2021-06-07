package com.example.mvvmexample

import com.example.mvvmexample.api.ApiService
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        val okhttpClient = OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .build()
        Retrofit.Builder()
            .client(okhttpClient)
            .baseUrl("https://dapi.kakao.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

var myNetworkModule = listOf(networkModule)