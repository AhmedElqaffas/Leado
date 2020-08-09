package com.example.leado.mainNavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.leado.R
import kotlinx.android.synthetic.main.activity_main_navigation.*

class MainNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)

        setNavigationComponentAdapter()
    }

    private fun setNavigationComponentAdapter() {
        val navigationController: NavController = findNavController(R.id.fragmentsContainer)
        bottomNavigationView.setupWithNavController(navigationController)
    }
}