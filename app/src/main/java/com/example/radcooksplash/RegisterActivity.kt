package com.example.radcooksplash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.radcooksplash.Models.Register
import com.example.radcooksplash.databinding.ActivityRegisterBinding
import com.example.radcooksplash.viewModel.ViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: ViewModel
    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // imagengif
        val imagengif = findViewById<ImageView>(R.id.gifImageView3)
        Glide.with(this).asGif().load(R.drawable.registrogif).into(imagengif);

        // boton
        val button: Button = findViewById(R.id.registerButton)
        button.setOnClickListener {
            CrearRegistro()
        }
    }

    // Obtener referencias a las vistas
    private fun CrearRegistro() {
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)

        // Validar que los campos no estén vacíos
        if (etName.text.toString().isNotEmpty() && etEmail.text.toString().isNotEmpty() && etPassword.text.toString().isNotEmpty()) {
            val DatosRegistro = Register(
                nombre = etName.text.toString(),
                correo = etEmail.text.toString(),
                contraseña = etPassword.text.toString()
            )
            viewModel = ViewModelProvider(this)[ViewModel::class.java]

            viewModel.registrar(DatosRegistro) { respuesta ->
                val res = respuesta?.status.toString()
                Log.d("Respuesta api", res)
                if (res == "ok") {
                    Toast.makeText(this, "Registro Fallido", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()

                    // Redirigir a la pantalla de inicio de sesión
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}
