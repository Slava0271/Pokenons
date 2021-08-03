package com.example.pokemonsinfo.ui.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemonsinfo.viewmodel.PokemonsViewModel

class PokemonsFragmentFactory(
    private val application: Application
) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonsViewModel::class.java)) {
            return PokemonsViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}