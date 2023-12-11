package com.example.radcooksplash.Models
import com.google.gson.annotations.SerializedName;

class Login (
    @SerializedName("email")
    var email: String,

    @SerializedName("password")
    var contraseña: String,
)