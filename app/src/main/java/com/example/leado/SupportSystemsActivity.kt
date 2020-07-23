package com.example.leado

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlinx.android.synthetic.main.activity_support_systems.*

class SupportSystemsActivity : AppCompatActivity(), SurfaceHolder.Callback {
    lateinit var mediaPlayer : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support_systems)
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
}