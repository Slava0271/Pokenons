package com.example.pokemonsinfo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.pokemonsinfo.R
import com.example.pokemonsinfo.databinding.FragmentPokemonsBinding
import com.example.pokemonsinfo.ui.factory.PokemonsFragmentFactory
import com.example.pokemonsinfo.viewmodel.PokemonsViewModel

class PokemonsFragment : Fragment() {
    private lateinit var binding: FragmentPokemonsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_pokemons, container, false
        )
        val application = requireNotNull(this.activity).application

        val viewModelFactory = PokemonsFragmentFactory(application)

        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(PokemonsViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        return binding.root
    }

}