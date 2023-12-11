package com.example.radcooksplash.Models

import com.google.gson.annotations.SerializedName

class RegisterIngredient(
    @SerializedName("name")
    var nombre: String,

    @SerializedName("type")
    var tipo: String
)