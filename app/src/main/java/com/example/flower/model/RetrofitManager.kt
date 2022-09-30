package com.example.retrofitconnection.gson

import com.example.flower.model.HarvestData
import com.example.retrofitconnection.utils.API
import retrofit2.Retrofit
import com.example.retrofitconnection.utils.Constants.TAG
import com.example.retrofitconnection.utils.RESPONSE_STATE
import com.google.gson.JsonArray
import io.reactivex.Single
import org.json.JSONArray
import java.lang.Exception

sealed class ResponseState

data class SuccessResponseState(
    val value: List<HarvestData>?
):ResponseState()

object LoadingResponseState : ResponseState()
object ErrorResponseState : ResponseState()

class RetrofitManager {

    companion object {
        val instance = RetrofitManager()
    }

    private val iRetrofit : IRetrofit? = RetrofitClient.getClient(API.BASE_URL)?.create(IRetrofit::class.java)
    private val harvestDataList = ArrayList<HarvestData>()

    //사진 검색 api 호출
    fun searchPhotos(searchTerm: String) : Single<ResponseState>? {
        return iRetrofit?.searchPhotos(searchTerm)?.map {
            if(it.code() == 200){
                harvestDataList.add(it.body()!!)
                SuccessResponseState(harvestDataList)
            }else{
                ErrorResponseState
            }
        }
//        //널처리 방법 중하나 Unwrapping //옵셔널로 선언하면 널을 받을 수 있지만 필수로 필요한 인자는 ? 옵셔널을 빼야하기 때문에 이런 후 처리 방법들을 사용
//        val term = searchTerm.let {
//            it
//        }?: ""
//        // val term = searchTerm? : ""  // 과 동일
//        val call = iRetrofit?.searchPhotos(searchTerm = term).let {
//            it
//        }?: return

//        call.enqueue(object : retrofit2.Callback<JsonElement>{
//            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
//                Log.d(TAG, "response success ${response.body()}")
//                when(response.code()) {
//                    200 -> {
//                        response.body()?.let { completion(RESPONSE_STATE.OKAY, it.asJsonArray) }
//                    }
//                    else -> {
//                        response.body()?.let { completion(RESPONSE_STATE.FAIL, it.asJsonArray) }
//
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<JsonElement>, throwable: Throwable) {
//                Log.d(TAG, "response failure ${throwable}")
//                completion(RESPONSE_STATE.FAIL, throwable.toString())
//
//            }
//
//        })


    }
}