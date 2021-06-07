package com.example.mvvmexample.di

import com.example.mvvmexample.api.ApiService
import com.example.mvvmexample.model.DataModel
import com.example.mvvmexample.model.DataModelImpl
import com.example.mvvmexample.viewmodel.MainViewModel
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val BASE_URL = "https://dapi.kakao.com"

val networkModule = module {
    single {
        val okhttpClient = OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>())
            .build()
        Retrofit.Builder()
            .client(okhttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

var modelPart = module {
    factory<DataModel> {
        DataModelImpl(get())
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

var myDiModule = listOf(modelPart, viewModelPart, networkModule)

