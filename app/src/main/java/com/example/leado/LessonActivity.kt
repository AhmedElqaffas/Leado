package com.example.leado

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
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
        progress_card_1.setBackgroundResource(getProgressBackground(true))
        progress_card_2.setBackgroundResource(getProgressBackground(progress>=2))
        progress_card_3.setBackgroundResource(getProgressBackground(progress>=3))
        progress_card_4.setBackgroundResource(getProgressBackground(progress>=4))
    }
    private fun getProgressBackground(isActive : Boolean) = if(isActive) R.drawable.rounded_background_active
    else R.drawable.rounded_background_inactive

}