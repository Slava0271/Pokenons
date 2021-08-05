package com.example.pokemonsinfo.pokemon

import com.squareup.moshi.Json

data class Result(
    @Json(name = "results") val results: List<Any>
)