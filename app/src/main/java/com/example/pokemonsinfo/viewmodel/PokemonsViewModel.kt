package com.example.pokemonsinfo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonsinfo.network.PokemonApi
import kotlinx.coroutines.launch

class PokemonsViewModel(application: Application) : AndroidViewModel(application) {
    init {
        connect()
    }

    private fun connect() {
        viewModelScope.launch {
            try {
                val listResult = PokemonApi.RETROFIT_SERVICE.getProperties()
                Log.d("listResult", "$listResult")
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("errorResult", e.toString())
            }
        }
    }
}