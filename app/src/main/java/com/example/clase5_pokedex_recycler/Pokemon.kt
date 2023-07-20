package com.example.clase5_pokedex_recycler

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
    var name: String,
    val life: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int,
    val type: PokemonType,
    val url: String
): Parcelable

enum class PokemonType {
    PLANTA, FUEGO, AGUA, LUCHA, ELECTRICO
}
