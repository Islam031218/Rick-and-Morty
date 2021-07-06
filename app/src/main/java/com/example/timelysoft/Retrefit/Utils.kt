package com.example.timelysoft.Retrefit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Utils {
    const val BASE_URL ="https://rickandmortyapi.com/"
    const val IMAGE = "https://image.tmdb.org/t/p/w500/"

    fun getRetrofitService() : NetworkUtils {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(NetworkUtils :: class.java)
    }

}