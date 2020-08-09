package com.example.leado.mainNavigation.fragments.achievements.leaderboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.leado.Person

class LeaderboardViewModel: ViewModel() {

    fun getLeaderboard(): LiveData<List<Person>> {
        return LeaderboardRepository.getLeaderboard()
    }
}