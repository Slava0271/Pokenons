package com.example.pokemonsinfo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pokemonsinfo.database.pokemon.Pokemon
import com.example.pokemonsinfo.database.pokemon.PokemonDao

@Database(
    entities = [Pokemon::class],
    version = 6, exportSchema = false
)
abstract class DataBase : RoomDatabase() {
    abstract val pokemonDao: PokemonDao


    companion object {
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getInstance(context: Context): DataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "data_base"
                    )
                        .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}