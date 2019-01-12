package com.sunflower.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.idescout.sql.SqlScoutServer
import com.sunflower.R


class GardenActivity : AppCompatActivity() {
    private var sqlScoutServer: SqlScoutServer? = null
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garden)

        navController = Navigation.findNavController(this, R.id.activity_garden_fragment)
        sqlScoutServer = SqlScoutServer.create(this, packageName)

        setupBottomNavMenu(navController)
    }

    override fun onSupportNavigateUp(): Boolean =
        Navigation.findNavController(this, R.id.activity_garden_fragment).navigateUp()

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.activity_garden_bnv)
        bottomNav?.setupWithNavController(navController)
    }

    override fun onDestroy() {
        sqlScoutServer?.destroy()
        super.onDestroy()
    }
}
