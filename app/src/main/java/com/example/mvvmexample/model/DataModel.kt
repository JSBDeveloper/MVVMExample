package com.example.mvvmexample.model

import com.example.mvvmexample.model.enum.KakaoSearchSortEnum
import com.example.mvvmexample.response.ImageSearchResponse
import io.reactivex.rxjava3.core.Single

interface DataModel {
    fun getData(
        query: String,
        sort: KakaoSearchSortEnum,
        page: Int,
        size: Int
    ): Single<ImageSearchResponse>
}

