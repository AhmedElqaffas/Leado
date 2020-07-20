package com.example.leado.recyclerAdapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leado.Person
import com.example.leado.R
import kotlinx.android.synthetic.main.item_leaderboard.view.*
import java.text.NumberFormat

class LeaderboardRecyclerAdapter(private val recyclerItemsList: MutableList<Person>):
    RecyclerView.Adapter<LeaderboardRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View, private val itemPosition: Int): RecyclerView.ViewHolder(itemView){

        fun bindData(person: Person){
            itemView.personImageView.setImageResource(person.image)
            itemView.personName.text = person.name
            itemView.personPoints.text = "${addSeparatorsToNumber(person.points)} Points"
            itemView.rank.text = recyclerItemsList.indexOf(person).plus(1).toString()

            customizeRankShapeAccordingToPosition(itemPosition)

        }

        private fun addSeparatorsToNumber(number: Int): String{
            return NumberFormat.getNumberInstance().format(number)
        }

        private fun customizeRankShapeAccordingToPosition(itemPosition: Int) {
            if(itemPosition == 0){
                itemView.itemLayout.setBackgroundColor(Color.parseColor("#22d0c4"))
                itemView.rank.setTextColor(Color.parseColor("#1f314a"))
                itemView.rank.alpha = 1f
            }
            else if(itemPosition < 3){
                itemView.rank.alpha = 1f
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardRecyclerAdapter.ViewHolder {
        val inflated = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leaderboard, parent, false)
        return ViewHolder(inflated, viewType)
    }

    override fun onBindViewHolder(holder: LeaderboardRecyclerAdapter.ViewHolder, position: Int) {
        holder.bindData(recyclerItemsList[position])
    }

    override fun getItemCount(): Int {
        return recyclerItemsList.size
    }
}