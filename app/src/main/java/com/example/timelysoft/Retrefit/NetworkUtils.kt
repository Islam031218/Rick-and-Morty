package com.example.timelysoft.Retrefit

import com.example.timelysoft.dataClasses.CharacterList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkUtils {
    @GET("api/character")
    suspend fun getCharacters(
        @Query("page") page : Int
    ): Response<CharacterList>


    @GET("api/character")
    suspend fun getCharactersByName(
        @Query("name") name : String
    ): Response<CharacterList>
}