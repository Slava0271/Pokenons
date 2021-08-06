package com.example.pokemonsinfo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonsinfo.database.pokemon.Pokemon
import com.example.pokemonsinfo.databinding.PokemonItemBinding


class PokemonViewHolder(private val binding: PokemonItemBinding , val images:List<Int>) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Pokemon, listener: ((Pokemon) -> Unit)?,position: Int) {
        binding.pokemon = item
        binding.userContainer.setOnClickListener {
            listener?.invoke(item)
        }
        binding.imageView.setImageResource(images[position])
    }
}