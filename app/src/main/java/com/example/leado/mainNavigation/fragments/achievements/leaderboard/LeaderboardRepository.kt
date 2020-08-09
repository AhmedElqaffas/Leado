package com.example.leado.mainNavigation.fragments.achievements.leaderboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.leado.data.Person
import com.example.leado.R

object LeaderboardRepository {
    private val dataList = mutableListOf(
        Person(
            "Tyler Joseph",
            R.drawable.achievement1_icon,
            "",
            20000,
            17,
            2,
            mutableListOf()
        ),
        Person(
            "Squidward tentacles",
            R.drawable.squidward_profile_image,
            "",
            10000,
            5,
            4,
            mutableListOf()
        ),
        Person(
            "Jason Statham",
            R.drawable.achievement3_icon,
            "",
            50000,
            50,
            1,
            mutableListOf()
        ),
        Person(
            "Pierre-Emerick Aubamayang",
            R.drawable.achievement1_icon,
            "",
            5000,
            17,
            5,
            mutableListOf()
        ),
        Person(
            "Dan Reynolds",
            R.drawable.achievement2_icon,
            "",
            18000,
            10,
            3,
            mutableListOf()
        ),
        Person(
            "Chelsea Fan",
            R.drawable.achievement4_icon,
            "",
            0,
            0,
            6,
            mutableListOf()
        )
    )

    private val leaderboardLiveData: MutableLiveData<List<Person>> = MutableLiveData()


    fun getLeaderboard(): LiveData<List<Person>>{
        sortFakeList()

        leaderboardLiveData.value = dataList
        return leaderboardLiveData
    }


    private fun sortFakeList(){
        dataList.sortWith(compareBy { it.rank })
    }
}