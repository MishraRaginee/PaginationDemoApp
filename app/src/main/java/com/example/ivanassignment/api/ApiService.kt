package com.example.paginationdemoapp


import com.example.ivanassignment.response.PojoResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("http://www.omdbapi.com/")
    fun getSearchData(@Query("s") searchKey:String,@Query("apikey") apiKey:String): Call<List<PojoResponse>>

    companion object {
        var retrofitService: ApiService? = null

        fun getInstance() : ApiService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://www.omdbapi.com/?")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ApiService::class.java)
            }
            return retrofitService!!
        }
    }
}