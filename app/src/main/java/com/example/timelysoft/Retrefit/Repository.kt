package com.example.timelysoft.Retrefit

import com.example.timelysoft.dataClasses.CharacterList
import retrofit2.Response

class Repository {

    suspend fun getCharacters(
        page:Int
    ):Response<CharacterList>{
        return Utils.getRetrofitService().getCharacters(page)
    }

    suspend fun getCharactersByName(
       name : String
    ):Response<CharacterList>{
        return Utils.getRetrofitService().getCharactersByName(name)
    }
}