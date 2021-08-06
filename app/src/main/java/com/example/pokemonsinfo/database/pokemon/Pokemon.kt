package com.example.pokemonsinfo.database.pokemon

import android.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "pokemon_table")
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    var pokemonId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "url")
    var url: String = "",

    @ColumnInfo(name = "backgroundColor")
    var backgroundColor: Int = Color.argb(
        255, Random().nextInt(256),
        Random().nextInt(256), Random().nextInt(256)
    )
)