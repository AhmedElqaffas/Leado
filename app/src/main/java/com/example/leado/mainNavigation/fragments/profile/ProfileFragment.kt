package com.example.leado.mainNavigation.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.leado.data.Achievement
import com.example.leado.R
import com.example.leado.data.Person
import com.example.leado.recyclerAdapters.AchievementsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPersonStats()
    }

    private fun setupPersonStats(){
        profileViewModel.getStats().observe(viewLifecycleOwner){
            showBio(it)
            showNumbers(it)
            showAchievements(it)
        }
    }

    private fun showBio(person: Person){
        profileImageView.setImageResource(person.image)
        nameTextView.text = person.name
        occupationTextView.text = person.occupation
    }

    private fun showNumbers(person: Person){
        coursesTextView.text = person.courses.toString()
        pointsTextView.text = person.points.toString()
        rankTextView.text = person.rank.toString()
    }

    private fun showAchievements(person: Person) {
        profileAchievementsRecyclerView.adapter = AchievementsRecyclerAdapter(person.badges)
    }

}