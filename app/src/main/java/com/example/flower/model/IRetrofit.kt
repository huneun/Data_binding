package com.example.retrofitconnection.gson

import com.example.flower.model.HarvestData
import com.example.retrofitconnection.utils.API
import com.google.gson.JsonElement
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IRetrofit {

    // https://www.unsplash.com/search/photos/?query=""

    @GET(API.SEARCH_PHOTOS)
    fun searchPhotos(@Query("query") searchTerm: String) : Single<Response<HarvestData>>

    @GET(API.SEARCH_USERS)
    fun searchUsers(@Query("query") searchTerm: String) : Single<List<HarvestData>>

}