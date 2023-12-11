package com.example.radcooksplash.Models

import com.google.gson.annotations.SerializedName

class Recipe (
    @SerializedName("name")
    var name: String,

    @SerializedName("category")
    var category: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("detail")
    var detail: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("ingredients")
    var ingredients: Array<Ingredient>,
)