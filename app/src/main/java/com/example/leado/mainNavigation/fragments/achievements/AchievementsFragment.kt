package com.example.leado.mainNavigation.fragments.achievements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leado.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_achievements.*

class AchievementsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_achievements, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTabLayoutListener()
        chooseLeaderboardTabByDefault()
    }

    private fun setTabLayoutListener(){
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> showBadgesFragment()
                    1 -> showLeaderboardFragment()
                }
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

        })
    }

    /**
     * Currently, this function removes the leaderboard fragment if present. The code should be
     * adjusted to show badges fragment if it is required to have a badges fragment
     */
    private fun showBadgesFragment(){
        val leaderboardFragment = childFragmentManager.findFragmentByTag("leaderboard")
        leaderboardFragment?.let{
            childFragmentManager.beginTransaction().remove(it).commit()
        }
    }

    private fun showLeaderboardFragment(){
        childFragmentManager.beginTransaction().replace(R.id.frameLayout, LeaderboardFragment(),
            "leaderboard").commit()
    }

    private fun chooseLeaderboardTabByDefault(){
        tabLayout.selectTab(tabLayout.getTabAt(1))
    }

}