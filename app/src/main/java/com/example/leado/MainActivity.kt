package com.example.leado

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.leado.mainNavigation.MainNavigationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setClickListeners()
    }

    private fun setClickListeners(){
        setGetStartedButtonClickListener()
    }

    private fun setGetStartedButtonClickListener(){
        getStartedButton.setOnClickListener {
            goToMainNavigationActivity()
        }
    }

    private fun goToMainNavigationActivity(){
        val intent = Intent(this, MainNavigationActivity::class.java)
        startActivity(intent)
    }
}