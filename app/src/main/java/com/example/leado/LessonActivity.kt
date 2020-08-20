package com.example.leado

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import androidx.core.graphics.toColorInt
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_lesson.*

class LessonActivity : YouTubeBaseActivity() , YouTubePlayer.OnInitializedListener{

    val apiKey = "AIzaSyCsXYSFIdEiNn3kvHWYHAj4raCuFVN0ESA"
    val id = "tGdsOXZpyWE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        setCourseProgress(intent.getIntExtra("Lesson Number",1))
        lessonText.text = intent.getStringExtra("Section Name")
        lesson_number_text.text = intent.getStringExtra("Lesson Name")

        lesson_player.initialize(apiKey,this)


    }



    private fun setCourseProgress(progress:Int) {
        progress_card_1.setCardBackgroundColor(getProgressColor(progress>=1))
        progress_card_2.setCardBackgroundColor(getProgressColor(progress>=2))
        progress_card_3.setCardBackgroundColor(getProgressColor(progress>=3))
        progress_card_4.setCardBackgroundColor(getProgressColor(progress>=4))
        progress_card_5.setCardBackgroundColor(getProgressColor(progress>=5))
    }
    private fun getProgressColor(isActive : Boolean) = if(isActive) "#00DC84".toColorInt()
        else "#9A9C9C9C".toColorInt()

    override fun onInitializationSuccess( p0: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, wasRestored: Boolean) {
        if(!wasRestored)
        {
            youTubePlayer?.cueVideo(id)
            youTubePlayer?.play()
        }
    }

    override fun onInitializationFailure( p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        TODO("Not yet implemented")
    }

}