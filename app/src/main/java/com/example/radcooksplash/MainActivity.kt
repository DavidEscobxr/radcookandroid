package com.example.radcooksplash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.radcooksplash.viewModel.ViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]


        val registerButton = findViewById<Button>(R.id.registerMainButton)
        val loginButton = findViewById<Button>(R.id.loginMainButton)

        val imagengif= findViewById<ImageView>(R.id.gifImageView)

        Glide.with(this).asGif().load(R.drawable.agucate).into(imagengif);



        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }

}


