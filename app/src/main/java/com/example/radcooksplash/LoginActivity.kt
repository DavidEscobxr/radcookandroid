package com.example.radcooksplash


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.radcooksplash.Models.Login
import com.example.radcooksplash.viewModel.ViewModel
import com.google.gson.Gson

class LoginActivity : AppCompatActivity() {
    private lateinit var etLoginEmail: EditText
    private lateinit var etLoginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var viewModel: ViewModel


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        // Obtener referencias a las vistas
        etLoginEmail = findViewById(R.id.etLoginEmail)
        etLoginPassword = findViewById(R.id.etLoginPassword)

        loginButton = findViewById(R.id.loginButton)

        val imagengif = findViewById<ImageView>(R.id.gifImageView2)
        Glide.with(this).asGif().load(R.drawable.logingif).into(imagengif)

        fun forgotPasswordClicked(view: View) {

        }

        // Configurar el listener para el botón de inicio de sesión
        loginButton.setOnClickListener {

            val email = etLoginEmail.text.toString()
            val contraseña = etLoginPassword.text.toString()

            Log.d("EMAIL","$email")
            Log.d("CONTRASEÑA","$contraseña")

            if (email.isNotEmpty()&& contraseña.isNotEmpty()){
                iniciarSesion(email, contraseña)
            }else{
                Toast.makeText(this, "Ingresa los datos", Toast.LENGTH_SHORT).show()

            }
        }
    }
    private fun iniciarSesion(usuario:String,contraseña:String){
        val datosLogin = Login(
            email = usuario,
            contraseña = contraseña
        )
        viewModel.login(datosLogin){respuesta ->
            if (respuesta !=null){
                val gson = Gson()
                val json = gson.toJson(respuesta)
                Log.d("Respuesta JSON", json)

                val intent = Intent (this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                Toast.makeText(this@LoginActivity,"Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                Toast.makeText(this,"Error inicio de sesión", Toast.LENGTH_SHORT).show()
            }
        }
    }

}