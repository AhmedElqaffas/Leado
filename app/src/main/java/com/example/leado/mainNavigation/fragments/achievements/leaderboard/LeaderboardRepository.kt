package com.example.leado.mainNavigation.fragments.achievements.leaderboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.leado.Person
import com.example.leado.R

object LeaderboardRepository {
    private val dataList = mutableListOf(
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

    private val leaderboardLiveData: MutableLiveData<List<Person>> = MutableLiveData()


    fun getLeaderboard(): LiveData<List<Person>>{
        sortFakeList(
            dataList
        )

        leaderboardLiveData.value = dataList
        return leaderboardLiveData
    }


    private fun sortFakeList(list: MutableList<Person>){
        list.sortWith(compareByDescending { it.points })
    }
}