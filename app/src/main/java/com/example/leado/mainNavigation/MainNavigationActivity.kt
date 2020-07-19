package com.example.leado.mainNavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.leado.R
import com.example.leado.mainNavigation.Fragments.AchievementsFragment
import com.example.leado.mainNavigation.Fragments.HomeFragment
import com.example.leado.mainNavigation.Fragments.ProfileFragment
import com.example.leado.viewpagerAdapters.MainNavigationViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main_navigation.*

class MainNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)

        setViewPagerAdapter()
        linkViewPagerAndBottomNavigation()
    }

    private fun setViewPagerAdapter() {
        val fragmentsList = listOf(
            HomeFragment(),
            AchievementsFragment(),
            ProfileFragment()
        )
        mainNavigationViewPager.adapter = MainNavigationViewPagerAdapter(fragmentsList,supportFragmentManager,
            lifecycle)
    }

    private fun linkViewPagerAndBottomNavigation() {
        setViewPagerChangeListener()
        setupBottomNavigationChangeListener()
    }

    private fun setViewPagerChangeListener() {
        mainNavigationViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })
    }

    private fun setupBottomNavigationChangeListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home ->
                    mainNavigationViewPager.setCurrentItem(0, true)
                R.id.achievements ->
                    mainNavigationViewPager.setCurrentItem(1, true)
                R.id.profile ->
                    mainNavigationViewPager.setCurrentItem(2, true)
            }
            true
        }
    }
}