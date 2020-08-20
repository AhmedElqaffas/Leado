package com.example.leado

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import androidx.core.graphics.toColorInt
import kotlinx.android.synthetic.main.activity_journey.*
import kotlinx.android.synthetic.main.activity_lesson.*

class LessonActivity : AppCompatActivity(), SurfaceHolder.Callback {
    lateinit var mediaPlayer : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
            var surfaceHolder = course_video_player.holder
            surfaceHolder.setFixedSize(800, 500)
            surfaceHolder.addCallback(this)
            mediaPlayer = MediaPlayer.create(this, R.raw.sample_video)

        setCourseProgress(intent.getIntExtra("Lesson Number",1))

        lessonText.text = intent.getStringExtra("Section Name")
        lesson_number_text.text = intent.getStringExtra("Lesson Name")
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
    }

    override fun surfaceDestroyed(p0: SurfaceHolder?) {
    }

    override fun surfaceCreated(p0: SurfaceHolder?) {
        mediaPlayer.setDisplay(p0)
        mediaPlayer.start()
    }

    override fun onPause() {
        if(mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            mediaPlayer.release()
        }
        super.onPause()

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

}