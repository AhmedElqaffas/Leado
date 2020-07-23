package com.example.leado.recyclerAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leado.R
import com.example.leado.data.Lesson
import kotlinx.android.synthetic.main.item_lesson.view.*


class LessonsRecyclerViewAdapter (val context: Context, val lessons : List<Lesson>) : RecyclerView.Adapter<LessonsRecyclerViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(lesson: Lesson)
        {
            itemView.textView_sectionName.text = lesson.sectionName
            itemView.textView_lessonName.text = lesson.name
            itemView.textview_lessonDescription.text = lesson.description
            itemView.button_start.isActivated = lesson.available
            itemView.button_start.setBackgroundResource(
                if(itemView.button_start.isActivated)
                    R.drawable.rounded_background_active
                else
                    R.drawable.rounded_background_inactive
            )
            itemView.button_start.text =
                if(itemView.button_start.isActivated)
                    "Start"
                else
                    "Locked"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_lesson,parent,false))
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(lessons[position])
    }
}