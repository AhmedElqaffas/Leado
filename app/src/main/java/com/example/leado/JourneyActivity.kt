package com.example.leado

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.example.leado.data.Lesson
import com.example.leado.data.Section
import com.example.leado.recyclerAdapters.LessonsRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_journey.*

class JourneyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey)

        setCourseProgress(3)

        setSections(getFakeSections())

        getFakeLessons("Support Systems")?.let { populateLessonsRecyclerView(it) }

        textView_courseName.text = intent.getStringExtra("Course Name")
        textView_roomName.text = textView_courseName.text.toString() +" Room"
    }


    private fun setCourseProgress(progress:Int) {
        lesson1_progress.setBackgroundResource(getProgressBackground(true))
        lesson2_progress.setBackgroundResource(getProgressBackground(progress>=2))
        lesson3_progress.setBackgroundResource(getProgressBackground(progress>=3))
        lesson4_progress.setBackgroundResource(getProgressBackground(progress>=4))
    }
    private fun getProgressBackground(isActive : Boolean) = if(isActive) R.drawable.rounded_background_active
        else R.drawable.rounded_background_inactive


    private fun setSections(sections: List<Section>) {
        imageView_section1.setImageResource(if(sections[0].isActive) sections[0].imageId else R.drawable.info)
        textView_section1.text = sections[0].name
        textView_section1.setTextColor(if(sections[0].isActive) ResourcesCompat.getColor(resources,R.color.text_color,null) else ResourcesCompat.getColor(resources,R.color.text_color_light,null))
        textView_section1.setBackgroundResource(if(sections[0].isActive) R.drawable.rounded_background_white else R.drawable.rounded_background_white_transparent)
        done_imageView_section1.visibility = if(sections[0].isDone) View.VISIBLE else View.INVISIBLE
        textView_section1.setOnClickListener {
            getFakeLessons(sections[0].name)?.let { it1 -> populateLessonsRecyclerView(it1) }
        }
        textView_section1.isEnabled = sections[0].isActive

        imageView_section2.setImageResource(if(sections[1].isActive) sections[1].imageId else R.drawable.info)
        textView_section2.text = sections[1].name
        textView_section2.setTextColor(if(sections[1].isActive) ResourcesCompat.getColor(resources,R.color.text_color,null) else ResourcesCompat.getColor(resources,R.color.text_color_light,null))
        textView_section2.setBackgroundResource(if(sections[1].isActive) R.drawable.rounded_background_white else R.drawable.rounded_background_white_transparent)
        done_imageView_section2.visibility = if(sections[1].isDone) View.VISIBLE else View.INVISIBLE
        textView_section2.setOnClickListener {
            getFakeLessons(sections[1].name)?.let { it1 -> populateLessonsRecyclerView(it1) }
        }
        textView_section2.isEnabled = sections[1].isActive


        imageView_section3.setImageResource(if(sections[2].isActive) sections[2].imageId else R.drawable.info)
        textView_section3.text = sections[2].name
        textView_section3.setTextColor(if(sections[2].isActive) ResourcesCompat.getColor(resources,R.color.text_color,null) else ResourcesCompat.getColor(resources,R.color.text_color_light,null))
        textView_section3.setBackgroundResource(if(sections[2].isActive) R.drawable.rounded_background_white else R.drawable.rounded_background_white_transparent)
        done_imageView_section3.visibility = if(sections[2].isDone) View.VISIBLE else View.INVISIBLE
        textView_section3.setOnClickListener {
            getFakeLessons(sections[2].name)?.let { it1 -> populateLessonsRecyclerView(it1) }
        }
        textView_section3.isEnabled = sections[2].isActive


        imageView_section4.setImageResource(if(sections[3].isActive) sections[3].imageId else R.drawable.info)
        textView_section4.text = sections[3].name
        textView_section4.setTextColor(if(sections[3].isActive) ResourcesCompat.getColor(resources,R.color.text_color,null) else ResourcesCompat.getColor(resources,R.color.text_color_light,null))
        textView_section4.setBackgroundResource(if(sections[3].isActive) R.drawable.rounded_background_white else R.drawable.rounded_background_white_transparent)
        done_imageView_section4.visibility = if(sections[3].isDone) View.VISIBLE else View.INVISIBLE
        textView_section4.setOnClickListener {
            getFakeLessons(sections[3].name)?.let { it1 -> populateLessonsRecyclerView(it1) }
        }
        textView_section4.isEnabled = sections[3].isActive

    }

    private fun populateLessonsRecyclerView(lessons :List<Lesson>) {
        lessons_recyclerView.adapter = LessonsRecyclerViewAdapter(this,lessons)
    }

    private fun getFakeSections() : List<Section>{
        val sections = mutableListOf<Section>()
        sections.add(Section(
            "Support System",
            true,
            true,
            R.drawable.book_shelf_1
        ))
        sections.add(Section(
            "Core Values",
            true,
            false,
            R.drawable.book_shelf_1
        ))
        sections.add(Section(
            "Strenth-Weakness",
            false,
            false,
            R.drawable.book_shelf_1
        ))
        sections.add(Section(
            "Goals & Aspiration",
            false,
            false,
            R.drawable.book_shelf_1
        ))
        return sections
    }

    val sectionsHash = HashMap<String,List<Lesson>>();
    private fun getFakeLessons(sectionName : String) : List<Lesson>?{
        if(sectionsHash.containsKey(sectionName))
            return sectionsHash[sectionName];
        val lessons = mutableListOf<Lesson>()
        lessons.add(Lesson(
            "Lesson 1",
            sectionName,
            "Building an integral support system,\n" +
                    "Pushes you to grow, strech more, mainly asks why things wont work, and bullet proofs ideas",
            true
        ))
        lessons.add(Lesson(
            "Lesson 2",
            sectionName,
            "Building an integral support system,\n" +
                    "Pushes you to grow, strech more, mainly asks why things wont work, and bullet proofs ideas",
            true
        ))
        lessons.add(Lesson(
            "Lesson 3",
            sectionName,
            "Building an integral support system,\n" +
                    "Pushes you to grow, strech more, mainly asks why things wont work, and bullet proofs ideas",
            false
        ))
        lessons.add(Lesson(
            "Lesson 4",
            sectionName,
            "Building an integral support system,\n" +
                    "Pushes you to grow, strech more, mainly asks why things wont work, and bullet proofs ideas",
            false
        ))

        sectionsHash[sectionName] = lessons;
        return lessons
    }
}