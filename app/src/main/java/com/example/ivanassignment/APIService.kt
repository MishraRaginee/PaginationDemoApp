package com.example.ivanassignment

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET()
    fun getMovieList(@Query("s") searchKey : String,@Query("apikey") apiKey : String )
}