package com.example.ivanassignment

import com.example.paginationdemoapp.ApiService

class MainRepository constructor(private val retrofitService: ApiService, val searchKey:String, val apiKey:String) {
    fun getSearchList() = retrofitService.getSearchData(searchKey = searchKey,apiKey = apiKey)
}