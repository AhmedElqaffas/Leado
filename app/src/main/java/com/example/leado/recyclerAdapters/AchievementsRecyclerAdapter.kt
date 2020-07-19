package com.example.leado.recyclerAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leado.Achievement
import com.example.leado.R
import kotlinx.android.synthetic.main.item_profile_achievement.view.*

class AchievementsRecyclerAdapter(private val recyclerItemsList: MutableList<Achievement>):
    RecyclerView.Adapter<AchievementsRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bindData(achievement: Achievement){
            itemView.achievementImageView.setImageResource(achievement.image)
            itemView.achievementTitle.text = achievement.title
            itemView.achievementDescription.text = achievement.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflated = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile_achievement, parent, false)
        return ViewHolder(inflated)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(recyclerItemsList[position])
    }

    override fun getItemCount(): Int {
        return recyclerItemsList.size
    }

}