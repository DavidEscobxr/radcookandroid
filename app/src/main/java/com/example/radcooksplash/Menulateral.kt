package com.example.radcooksplash


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

import android.annotation.SuppressLint
import android.content.Intent
import androidx.cardview.widget.CardView

class dasboard : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menulateral)

        //search
        val searchCard = findViewById<CardView>(R.id.searchCard)
        searchCard.setOnClickListener()
        {
            val intent = Intent(this@dasboard, Search::class.java)
            startActivity(intent)
        }

        //foro
        val forumCard = findViewById<CardView>(R.id.forumCard)
        forumCard.setOnClickListener()
        {
            val intent = Intent(this@dasboard, Forum::class.java)
            startActivity(intent)
        }

        //ingresar receta
        val enterrecipeCard = findViewById<CardView>(R.id.enterrecipeCard)
        enterrecipeCard.setOnClickListener()
        {
            val intent = Intent(this@dasboard, EnterRecipe::class.java)
            startActivity(intent)
        }

        //favoritos
        val favoriteCard = findViewById<CardView>(R.id.favoritetCard)
        favoriteCard.setOnClickListener()
        {
            val intent = Intent(this@dasboard, Favorite::class.java)
            startActivity(intent)
        }


    }
}


class Menulateral : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menulateral)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
            }
        }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

         when (item.itemId) {
             R.id.nav_home -> supportFragmentManager.beginTransaction()
             .replace(R.id.fragment_container, HomeFragment()).commit()

             R.id.nav_settings -> supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, SettingsFragment()).commit()

            R.id.nav_share -> supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ShareFragment()).commit()

            R.id.nav_about -> supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AboutFragment()).commit()


             R.id.nav_logout -> {

               val intent = Intent(this, MainActivity::class.java)

               // Iniciar la nueva actividad
               startActivity(intent)

           }}
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
        }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
           drawerLayout.closeDrawer(GravityCompat.START)
             } else {
            onBackPressedDispatcher.onBackPressed()
            }
        }
   }

