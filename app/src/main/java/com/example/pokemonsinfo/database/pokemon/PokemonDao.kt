package com.example.pokemonsinfo.database.pokemon

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PokemonDao {
    @Insert
    suspend fun insert(pokemon: Pokemon)

    @Update
    suspend fun update(pokemon: Pokemon)

    @Query("SELECT * FROM pokemon_table ORDER BY pokemonId ASC")
    suspend fun getAllUsers(): List<Pokemon>

    @Query("Delete from pokemon_table")
    suspend fun clear()

}