package com.example.leado.mainNavigation.fragments.achievements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leado.Person
import com.example.leado.R
import com.example.leado.recyclerAdapters.LeaderboardRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_leaderboard.*

class LeaderboardFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_leaderboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFakeAdapterList()
    }

    private fun setupFakeAdapterList() {
        val temporaryList = mutableListOf(
            Person(
                "Tyler Joseph",
                R.drawable.achievement1_icon,
                "",
                20000
            ),
            Person(
                "Squidward tentacles",
                R.drawable.squidward_profile_image,
                "",
                10000
            ),
            Person(
                "Jason Statham",
                R.drawable.achievement3_icon,
                "",
                50000
            ),
            Person(
                "Pierre-Emerick Aubamayang",
                R.drawable.achievement1_icon,
                "",
                5000
            ),
            Person(
                "Dan Reynolds",
                R.drawable.achievement2_icon,
                "",
                18000
            ),
            Person(
                "Chelsea Fan",
                R.drawable.achievement4_icon,
                "",
                0
            )
        )

        sortFakeList(temporaryList)

        pointsLeaderboardRecyclerView.adapter = LeaderboardRecyclerAdapter(temporaryList)
    }

    private fun sortFakeList(list: MutableList<Person>){
        list.sortWith(compareByDescending { it.points })
    }

}