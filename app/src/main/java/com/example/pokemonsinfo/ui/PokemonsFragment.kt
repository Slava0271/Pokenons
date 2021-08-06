package com.example.pokemonsinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonsinfo.R
import com.example.pokemonsinfo.adapter.PokemonAdapter
import com.example.pokemonsinfo.database.DataBase
import com.example.pokemonsinfo.databinding.FragmentPokemonsBinding
import com.example.pokemonsinfo.ui.factory.PokemonsFragmentFactory
import com.example.pokemonsinfo.viewmodel.PokemonsViewModel

class PokemonsFragment : Fragment() {
    private lateinit var binding: FragmentPokemonsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val list = listOf<Int>(
            R.drawable.test_1,
            R.drawable.test_2,
            R.drawable.test_3,
            R.drawable.test_4,
            R.drawable.test_5,
            R.drawable.test_6,
            R.drawable.test_7,
            R.drawable.test_8,
            R.drawable.test_9,
            R.drawable.test_10,
            R.drawable.test_11,
            R.drawable.test_12,
            R.drawable.test_13,
            R.drawable.test_14,
            R.drawable.test_15,
            R.drawable.test_16,
            R.drawable.test_17,
            R.drawable.test_18,
            R.drawable.test_19,
            R.drawable.test_20
        )

        val adapter = PokemonAdapter(listener = null, list)

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_pokemons, container, false
        )
        val application = requireNotNull(this.activity).application

        val dataSourceResults = DataBase.getInstance(application).pokemonDao

        val viewModelFactory = PokemonsFragmentFactory(application, dataSourceResults)

        val viewModel =
            ViewModelProvider(this, viewModelFactory).get(PokemonsViewModel::class.java)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.recycleView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recycleView.adapter = adapter

        viewModel.pokemonsViewModel.observe(viewLifecycleOwner, { adapter.submitList(it) })

        return binding.root
    }

}