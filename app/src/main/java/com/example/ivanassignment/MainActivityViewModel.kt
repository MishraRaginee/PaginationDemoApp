package com.example.ivanassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.ivanassignment.response.PojoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val searchList = MutableLiveData<List<PojoResponse>>()
    val errorMessage = MutableLiveData<String>()

    fun getSearchResult(apiKey:String,searchKey:String) {
        val response = repository.getSearchList()
        response.enqueue(object : Callback<List<PojoResponse>> {
            override fun onResponse(call: Call<List<PojoResponse>>, response: Response<List<PojoResponse>>) {
                searchList.postValue(response.body())
            }
            override fun onFailure(call: Call<List<PojoResponse>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}