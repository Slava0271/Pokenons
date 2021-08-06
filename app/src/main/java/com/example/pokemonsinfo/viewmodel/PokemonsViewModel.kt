package com.example.pokemonsinfo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.pokemonsinfo.R
import com.example.pokemonsinfo.database.pokemon.Pokemon
import com.example.pokemonsinfo.database.pokemon.PokemonDao
import com.example.pokemonsinfo.network.PokemonApi
import com.example.pokemonsinfo.parseresult.ParseResult
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonsViewModel(application: Application, val pokemonDao: PokemonDao) :
    AndroidViewModel(application) {

    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemonsViewModel: LiveData<List<Pokemon>> = _pokemons

    init {
        connect()
        onInit()
    }

    private fun onInit() {
        viewModelScope.launch(Dispatchers.IO) {
            _pokemons.postValue(pokemonDao.getAllUsers())
        }
    }

    private fun connect() {
        viewModelScope.launch {
            if (getAllPokemons().isEmpty()) {
                try {
                    _pokemons.postValue(pokemonDao.getAllUsers())
                    val listResult = PokemonApi.RETROFIT_SERVICE.getProperties()
                    val parseResult = ParseResult()

                    for (i in listResult.results.indices) {
                        val pokemon = parseResult.parsePokemon(listResult.results[i].toString())

                        insert(pokemon)
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private suspend fun insert(pokemon: Pokemon) {
        pokemonDao.insert(pokemon)
    }

    private suspend fun getAllPokemons(): List<Pokemon> {
        return pokemonDao.getAllUsers()
    }

    private suspend fun update(pokemon: Pokemon) {
        pokemonDao.update(pokemon)
    }
}