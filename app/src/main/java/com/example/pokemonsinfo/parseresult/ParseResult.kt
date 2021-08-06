package com.example.pokemonsinfo.parseresult

import com.example.pokemonsinfo.database.pokemon.Pokemon

class ParseResult {
    private fun parseListItem(item: String): List<String> {
        return item.split(", ")
    }

    fun parsePokemon(item: String): Pokemon {
        val parsedItem = parseListItem(item)
        val name = parsedItem.first().split("=").last()
        var url = parsedItem.last().split("=").last()
        url = url.substring(0, url.length - 1)
        val pokemon = Pokemon(name = name,url =url)
        return Pokemon(name = name, url = url )
    }
}