package com.example.leado.mainNavigation.fragments.achievements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.example.leado.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_achievements.*

class AchievementsFragment : Fragment() {

    private lateinit var controller: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_achievements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setInitialTab()
        setTabLayoutListener()
    }

    private fun setTabLayoutListener(){
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                controller = findNavController(achievementsFragmentsContainer)
                when(tab?.position){
                    0 -> {
                            controller.navigate(R.id.badgesFragment)
                    }
                    1 -> {
                        controller.navigate(R.id.leaderboardFragment)
                    }
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

        })
    }

    private fun setInitialTab(){
        tabLayout.selectTab(tabLayout.getTabAt(1))
    }

}