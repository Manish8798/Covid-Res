package com.example.covidres.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {

    @GET("continents?yesterday=true&sort")
    fun getResources():Call<List<Resource>>

    companion object {
        val BASE_URL = "https://corona.lmao.ninja/v2/"

        fun create(): Api {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(Api::class.java)
        }
    }

}