package com.example.timelysoft.Character

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.timelysoft.Retrefit.Repository
import com.example.timelysoft.dataClasses.CharacterList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel() : ViewModel(){

    var liveDataCharacters = MutableLiveData<CharacterList>()
    var  liveDataSearchCharacters = MutableLiveData<CharacterList>()
    val repository = Repository()


    fun getCharacters(page : Int){
        viewModelScope.launch (Dispatchers.IO){
            val response = repository.getCharacters(page)
            if (response.isSuccessful && response.body()!=null){
                withContext(Dispatchers.Main){
                    liveDataCharacters.value = response.body()!!
                    Log.i("MyTag", response.body().toString())
                }

            }
        }
    }

    fun getByName(name: String){
        viewModelScope.launch (Dispatchers.IO){
            val response = repository.getCharactersByName(name)
            if (response.isSuccessful && response.body()!=null){
                withContext(Dispatchers.Main){
                    liveDataSearchCharacters.value = response.body()
                    Log.i("MyTag", response.body().toString())
                }

            }
        }
    }

}