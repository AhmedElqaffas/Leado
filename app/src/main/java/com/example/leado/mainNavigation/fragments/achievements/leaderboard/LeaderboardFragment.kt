package com.example.leado.mainNavigation.fragments.achievements.leaderboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leado.R
import com.example.leado.mainNavigation.fragments.achievements.leaderboard.LeaderboardRepository
import com.example.leado.recyclerAdapters.LeaderboardRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_leaderboard.*

class LeaderboardFragment : Fragment() {

    private val leaderboardViewModel: LeaderboardViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_leaderboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFakeList()
    }

    private fun setupFakeList() {
        getLeaderboard()
    }

    private fun getLeaderboard(){
        leaderboardViewModel.getLeaderboard().observe(viewLifecycleOwner) {
            pointsLeaderboardRecyclerView.adapter = LeaderboardRecyclerAdapter(it.toMutableList())
        }
    }

}