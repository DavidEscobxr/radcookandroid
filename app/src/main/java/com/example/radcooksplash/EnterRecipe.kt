package com.example.radcooksplash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.radcooksplash.response.IngredientResponse
import com.example.radcooksplash.service.RetrofitClient
import com.example.radcooksplash.viewModel.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnterRecipe : AppCompatActivity() {

    private lateinit var viewModel: ViewModel
    private lateinit var AutoIngredientes: AutoCompleteTextView
    private val selectedIngredientIds = mutableListOf<Int>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_recipe)

        //imagen gif para tener movimiento
        val imagengif = findViewById<ImageView>(R.id.gifImageView4)
        Glide.with(this).asGif().load(R.drawable.registrogif).into(imagengif);

        val autoCompleteRecipe = findViewById<AutoCompleteTextView>(R.id.autoCompleteRecipe)
        val editTextCantidad = findViewById<EditText>(R.id.createIngredientes)
        val btnAgregarIngrediente = findViewById<Button>(R.id.crearButton)

        // tipo de recetas
        val items = listOf(
            "Panadería", "Postres", "Salsas", "Bebidas",
            "Ensaladas", "Platos principales", "Bocadillos", "Sopas",
            "Acompañamientos", "Comida rápidas"
        )

        //items de tipo de receta
        val autoComplete = findViewById<AutoCompleteTextView>(R.id.autoCompleteRecipe)
        val adapter = ArrayAdapter(this, R.layout.items_pqrs, items)
        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val tipoSelect = adapterView.getItemAtPosition(i)
                Toast.makeText(this, "$tipoSelect", Toast.LENGTH_SHORT).show()
            }

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        viewModel.loadIngredients()

         AutoIngredientes = findViewById<AutoCompleteTextView>(R.id.autoCompleteIngredientes)
         ingredientes()

    //ingredientes a receta
    }

    fun ingredientes(){
        viewModel.Ingredient.observe(this) { ingredients ->
            val ingredientNames =
                ingredients.map { it.name }

            val adapter =
                ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, ingredientNames)
            AutoIngredientes.setAdapter(adapter)

            AutoIngredientes.setOnItemClickListener { _, _, position, _ ->
                val selectedIngredient = ingredients[position]
                selectedIngredientIds.add(selectedIngredient.id)
            }
        }
    }
}
