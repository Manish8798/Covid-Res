package com.example.covidres.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidres.adapter.MyAdapter
import com.example.covidres.databinding.ActivityMainBinding
import com.example.covidres.model.Api
import com.example.covidres.model.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMainActivity.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
        }

        val api = Api.create().getResources()

        api.enqueue(object : Callback<List<Resource>>{
            override fun onResponse(
                call: Call<List<Resource>>,
                response: Response<List<Resource>>
            ) {
                if (response.isSuccessful) {
                    Log.d(TAG, "onResponse: ${response.body()}")
                    binding.rvMainActivity.adapter = MyAdapter(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Resource>>, t: Throwable) {
                Log.d(TAG, "onFailure: $call")
                Log.d(TAG, "onFailure: $t")
            }

        })
    }
}