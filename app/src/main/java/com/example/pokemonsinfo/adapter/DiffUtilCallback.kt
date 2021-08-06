package com.example.pokemonsinfo.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pokemonsinfo.database.pokemon.Pokemon

class DiffUtilCallback
    : DiffUtil.ItemCallback<Pokemon>() {
    override fun areItemsTheSame(
        oldItem: Pokemon,
        newItem: Pokemon
    ): Boolean {
        return oldItem.pokemonId == newItem.pokemonId
    }

    override fun areContentsTheSame(
        oldItem: Pokemon,
        newItem: Pokemon
    ): Boolean {
        return oldItem == newItem
    }
}