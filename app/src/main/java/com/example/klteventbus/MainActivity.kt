package com.example.klteventbus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val navFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
    }
    private val navController by lazy {
        navFragment.findNavController()
    }
    private val navView by lazy {
        findViewById<BottomNavigationView>(R.id.nav_view)
    }
    private val appBarConfiguration by lazy {
        AppBarConfiguration(
            setOf(
                R.id.dest_one,
                R.id.dest_two
            )
        )
    }

    companion object {
        const val NAV_ITEM_TYPE_ONE = "com.type.one"
        const val NAV_ITEM_TYPE_TWO = "com.type.two"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        navView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    fun addBadge(count: Int, type: String) {

        when (type) {
            NAV_ITEM_TYPE_ONE -> {

                navView.getOrCreateBadge(R.id.dest_one).apply {
                    number += count
                    isVisible = true
                }

            }
            NAV_ITEM_TYPE_TWO -> {
                navView.getOrCreateBadge(R.id.dest_two).apply {
                    number += count
                    isVisible = true
                }
            }

        }
    }

    fun clearBadge(type: String) {
        when (type) {
            NAV_ITEM_TYPE_ONE -> {
                navView.removeBadge(R.id.dest_one)
            }
            NAV_ITEM_TYPE_TWO -> {
                navView.removeBadge(R.id.dest_two)
            }
        }
    }
}