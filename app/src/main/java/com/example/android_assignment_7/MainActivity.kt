package com.example.android_assignment_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_assignment_7.adapter.UsersRecyclerAdapter
import com.example.android_assignment_7.api.models.ReqResData
import com.example.android_assignment_7.api.models.User
import com.example.android_assignment_7.api.models.services.RestClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RestClient.getRetrofit()
        RestClient.reqResService.getUsers(1, 10).enqueue(object : retrofit2.Callback<ReqResData<List<User>>> {
            override fun onResponse(call: retrofit2.Call<ReqResData<List<User>>>,
                                    response: retrofit2.Response<ReqResData<List<User>>>) {
                Log.d("MainActivity", "onResponse: ${response.body()?.data}")
                val data = response.body()?.data
                if (data != null) {
                    initAdapter(data)
                }
            }
            override fun onFailure(call: retrofit2.Call<ReqResData<List<User>>>, t: Throwable) {
                Log.d("MainActivity", "onFailure: ${t.message}")
            }
        })
    }

    fun initAdapter(users: List<User>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UsersRecyclerAdapter()
        adapter.setUsers(users)
        recyclerView.adapter = adapter
    }

}