package com.example.leado.data

import com.example.leado.R

data class Person(
                  val name: String,
                  val image: Int,
                  val occupation: String,
                  val points: Int,
                  val courses: Int,
                  val rank: Int,
                  val badges: MutableList<Achievement>)