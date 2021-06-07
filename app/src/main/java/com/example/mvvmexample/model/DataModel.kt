package com.example.mvvmexample.model

import com.example.mvvmexample.api.ApiService
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

class DataModelImpl(private val service: ApiService): DataModel {
    private val KAKAO_APP_KEY = "40dea0bc456c5b2b05ca88ebf567af57"

    override fun getData(
        query: String,
        sort: KakaoSearchSortEnum,
        page: Int,
        size: Int
    ): Single<ImageSearchResponse> {
        return service.searchImage(
            "KakaoAK ${KAKAO_APP_KEY}",
            query = query,
            sort = sort.sort,
            page = page,
            size = size
        )
    }
}