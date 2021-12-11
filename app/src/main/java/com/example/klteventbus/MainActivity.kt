package com.example.klteventbus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

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
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setupNavigation()
    }

    private fun setupNavigation() {
        navView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    fun checkBadge(count: Int, type: String) {

        when (type) {
            NAV_ITEM_TYPE_ONE -> {

                if (count == 0) {
                    navView.removeBadge(R.id.dest_one)
                    return
                }
                navView.getOrCreateBadge(R.id.dest_one).apply {
                    number = count
                    isVisible = true
                }


            }
            NAV_ITEM_TYPE_TWO -> {

                if (count == 0) {
                    navView.removeBadge(R.id.dest_two)
                    return
                }

                navView.getOrCreateBadge(R.id.dest_two).apply {
                    number = count
                    isVisible = true
                }


            }

        }
    }

}