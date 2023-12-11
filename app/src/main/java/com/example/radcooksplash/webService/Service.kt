package com.example.radcooksplash.webService

import com.example.radcooksplash.CreateIngredient
import com.example.radcooksplash.Models.Ingredient
import com.example.radcooksplash.Models.Login
import com.example.radcooksplash.Models.Recipe
import com.example.radcooksplash.Models.Register
import com.example.radcooksplash.Models.RegisterIngredient
import com.example.radcooksplash.response.IngredientResponse
import com.example.radcooksplash.response.RecipeResponse
import com.example.radcooksplash.response.loginResponse
import com.example.radcooksplash.response.registerResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Service {
    @POST("registro")
    fun Registrar(@Body datosRegistro: Register): Call<registerResponse>

    @POST ("login")
    fun Login(@Body datosLogin : Login): Call<loginResponse>

    @POST ("ingredients")
    fun Ingredient(@Body datosIngredient : RegisterIngredient): Call<IngredientResponse>

    @DELETE("ingredients/{id}")
    fun DeleteIngredient(@Path("id") id: Int): Call<IngredientResponse>

    @POST ("recipe/create")
    fun RecipeCreate(@Body datosRecipe : Recipe): Call<RecipeResponse>

    @GET("ingredients")
    fun getIngredient(): Call<List<Ingredient>>



}