package com.example.leado.mainNavigation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leado.JourneyActivity
import com.example.leado.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent = Intent(context, JourneyActivity::class.java)
        selfAwarenessBtn.setOnClickListener{
            intent.putExtra("Course Name",selfAwarenessBtn.text.toString())
            startActivity(intent)
        }
        mindBtn.setOnClickListener{
            intent.putExtra("Course Name",mindBtn.text.toString())
            startActivity(intent)
        }
        personalBtn.setOnClickListener{
            intent.putExtra("Course Name",personalBtn.text.toString())
            startActivity(intent)
        }
    }

}