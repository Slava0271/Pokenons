package com.example.pokemonsinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.pokemonsinfo.database.pokemon.Pokemon
import com.example.pokemonsinfo.databinding.PokemonItemBinding

class PokemonAdapter(
    private val listener: ((Pokemon) -> Unit)? = null,
    private val images: List<Int>
) :
    ListAdapter<Pokemon, PokemonViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding =
            PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PokemonViewHolder(binding, images)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(getItem(position), listener, position)
    }

}