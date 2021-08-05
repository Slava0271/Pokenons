package com.example.pokemonsinfo.network

import com.example.pokemonsinfo.pokemon.Result
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://pokeapi.co/api/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface PokemonApiService {
    @GET("pokemon/")
    suspend fun getProperties(): Result
}

object PokemonApi {
    val RETROFIT_SERVICE: PokemonApiService by lazy { retrofit.create(PokemonApiService::class.java) }
}