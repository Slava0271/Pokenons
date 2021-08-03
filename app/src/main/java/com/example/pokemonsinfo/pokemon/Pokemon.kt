package com.example.pokemonsinfo.pokemon

import com.squareup.moshi.Json

data class Pokemon(
    @Json(name = "results") val results: Any
)