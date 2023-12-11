package com.example.radcooksplash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.example.radcooksplash.viewModel.ViewModel
import com.google.android.material.navigation.NavigationView


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var viewModel: ViewModel

    class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_home)
            viewModel = ViewModelProvider(this)[ViewModel::class.java]
            drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

            val toolbar = findViewById<Toolbar>(R.id.toolbar)
            setSupportActionBar(toolbar)

            val navigationView = findViewById<NavigationView>(R.id.nav_view)
            navigationView.setNavigationItemSelectedListener(this)

            val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, HomeFragment())
                    .commit()
                navigationView.setCheckedItem(R.id.nav_home)
            }

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, HomeFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

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

                R.id.nav_logout-> {
                    //logout()
                    true
                }

            }
            drawerLayout.closeDrawer(GravityCompat.START)
            return true
        }

        override fun onBackPressed() {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                val fragmentManager = supportFragmentManager

                if (fragmentManager.backStackEntryCount > 0) {
                    // Si hay fragmentos en la pila de retroceso, pop al último fragmento
                    fragmentManager.popBackStack()
                } else {
                    // Si no hay fragmentos en la pila de retroceso, realiza el comportamiento predeterminado
                    super.onBackPressed()
                }
                onBackPressedDispatcher.onBackPressed()
            }
        }
    }
