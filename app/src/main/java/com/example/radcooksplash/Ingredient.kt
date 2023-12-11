package com.example.radcooksplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.radcooksplash.Adapter.IngredientListAdapter
import com.example.radcooksplash.Models.Ingredient
import com.example.radcooksplash.viewModel.ViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Ingredient : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_ingredients)

        initRecyclerView()

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this, CreateIngredient::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        var viewModel = ViewModelProvider(this)[ViewModel::class.java]

        viewModel.loadIngredients()

        viewModel.Ingredient.observe(this) { ingredients ->
            val items: ArrayList<Ingredient> = ArrayList(ingredients)

            val adapter = IngredientListAdapter(items, object: IngredientListAdapter.IngredientItemListener {
                override fun onDeleteClick(id: Int) {
                    viewModel = ViewModelProvider(this@Ingredient)[ViewModel::class.java]

                    viewModel.deleteIngredient(id) { respuesta ->
                        val res = respuesta?.message.toString()
                        if (res == "") {
                            Toast.makeText(this@Ingredient, "Falló la eliminación", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@Ingredient, "Eliminación exitosa!", Toast.LENGTH_SHORT).show()

                            // Redirigir a la pantalla de listar ingredientes
                            val intent = Intent(this@Ingredient, com.example.radcooksplash.Ingredient::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
            })

            recyclerView = findViewById(R.id.recycler_view)

            recyclerView.adapter = adapter
        }
    }
}