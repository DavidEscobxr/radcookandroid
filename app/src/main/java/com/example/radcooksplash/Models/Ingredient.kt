package com.example.radcooksplash.Models

import com.google.gson.annotations.SerializedName

class Ingredient(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("type")
    var type: String,
)
