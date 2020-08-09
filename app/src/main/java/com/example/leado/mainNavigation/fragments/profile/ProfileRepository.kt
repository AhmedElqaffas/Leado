package com.example.leado.mainNavigation.fragments.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.leado.R
import com.example.leado.data.Achievement
import com.example.leado.data.Person

object ProfileRepository {

    private val personLiveData: MutableLiveData<Person> = MutableLiveData()

    fun getStats(): LiveData<Person>{
        val person = getMyProfileStats()
        personLiveData.value = person
        return personLiveData
    }

    private fun getMyProfileStats(): Person{
        return Person(
            "Squidward tentacles", R.drawable.squidward_profile_image,
            "Krusty Krap Employee", 10000, 7, 4,
            mutableListOf(
                Achievement(
                    R.drawable.achievement1_icon,
                    "First Achievement",
                    "There is always a first time"
                ),
                Achievement(
                    R.drawable.achievement2_icon,
                    "The Great Achievement",
                    "A great achievement for a great person, keep learning"
                ),
                Achievement(
                    R.drawable.achievement3_icon, "Hattrick Hero",
                    "You have earned 3 achievements, keep going"
                ),
                Achievement(
                    R.drawable.achievement4_icon,
                    "Last But Not Least",
                    "Another one, GREAT!"
                ),
                Achievement(
                    R.drawable.achievement2_icon,
                    "A Temporary Title",
                    "To test more recycler elements"
                ),
                Achievement(
                    R.drawable.achievement1_icon, "Iron Man",
                    "Finished a course in less than a week"
                )
            )
        )
    }
}