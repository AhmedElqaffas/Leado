package com.example.leado.mainNavigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leado.Achievement
import com.example.leado.R
import com.example.leado.recyclerAdapters.AchievementsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFakeAdapterList()
    }

    private fun setupFakeAdapterList() {
        val temporaryList = mutableListOf<Achievement>(
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

        profileAchievementsRecyclerView.adapter = AchievementsRecyclerAdapter(temporaryList)
    }

}