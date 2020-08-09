package com.example.leado.mainNavigation.fragments.achievements.badges

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leado.R

/**
 * This is a dummy fragment to represent the "badges tab". It currently contains no data
 */
class BadgesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_badges, container, false)
    }
}