package com.example.ivanassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ivanassignment.response.PojoResponse
import com.example.paginationdemoapp.ApiService
import com.example.paginationdemoapp.adapter.SimpleAdapter

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    private val retrofitService = ApiService.getInstance()
    lateinit var  pagingAdapter: SimpleAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, MyViewModelfactory(MainRepository(retrofitService,"batman","adb8bcc5"))).get(MainActivityViewModel::class.java)

        viewModel.searchList.observe(this, Observer {
            setSearchListAdapter(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
        viewModel.getSearchResult("batman","adb8bcc5")



    }

    fun setSearchListAdapter(list: List<PojoResponse>){
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            adapter = SimpleAdapter(this@MainActivity,list[0].Search.toList())
        }

    }


}