package com.example.pokemonsinfo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonsinfo.ParseResult
import com.example.pokemonsinfo.network.PokemonApi
import com.example.pokemonsinfo.pokemon.Pokemon
import kotlinx.coroutines.launch

class PokemonsViewModel(application: Application) : AndroidViewModel(application) {
    init {
        connect()
    }

    private fun connect() {
        viewModelScope.launch {
            try {
                val listResult = PokemonApi.RETROFIT_SERVICE.getProperties()
                val parseResult = ParseResult()

                val listPokemons = mutableListOf<Pokemon>()

                for (i in listResult.results.indices) {
                    listPokemons.add(parseResult.parsePokemon(listResult.results[i].toString()))
                }

            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("errorResult", e.toString())
            }
        }
    }
}