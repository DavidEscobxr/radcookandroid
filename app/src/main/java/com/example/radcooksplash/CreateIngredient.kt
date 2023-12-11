package com.example.radcooksplash

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.radcooksplash.Models.RegisterIngredient
import com.example.radcooksplash.viewModel.ViewModel

class CreateIngredient : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etType: EditText
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredient)

        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteIngredient)
        val items = arrayOf("Fruta", "Verdura", "Carne roja", "Lácteo", "Carne blanca", "Mariscos", "Cereal")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items)
        autoCompleteTextView.setAdapter(adapter)

        val createButton = findViewById<Button>(R.id.crearIngrediente)
        createButton.setOnClickListener {
            CrearIngrediente()
        }
    }

    private fun CrearIngrediente() {
        etName = findViewById(R.id.nameIngredient)
        etType = findViewById(R.id.autoCompleteIngredient)

        // Validar que los campos no estén vacíos
        if (etName.text.toString().isNotEmpty() && etType.text.toString().isNotEmpty()) {
            val DatosRegistro = RegisterIngredient(
                nombre = etName.text.toString(),
                tipo = etType.text.toString()
            )

            viewModel = ViewModelProvider(this)[ViewModel::class.java]

            viewModel.CreateIngredient(DatosRegistro) { respuesta ->
                val res = respuesta?.id.toString()
                if (res == "0" || res == "") {
                    Toast.makeText(this, "Registro Fallido", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                    // Redirigir a la pantalla de listar ingredientes
                    val intent = Intent(this, Ingredient::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}