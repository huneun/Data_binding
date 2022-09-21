package com.example.flower.model

import com.example.retrofitconnection.utils.API
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {

    // https://www.unsplash.com/search/photos/?query=""

    @GET(API.SEARCH_PHOTOS)
    fun searchPhotos(@Query("query") searchTerm: String): Single<Response<List<HarvestData>>>

    @GET(API.SEARCH_USERS)
    fun searchUsers(@Query("query") searchTerm: String): Single<HarvestData>

}