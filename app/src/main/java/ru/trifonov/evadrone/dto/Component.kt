package ru.trifonov.evadrone.dto

import android.content.ClipDescription

abstract class Component(
    val id: Int,
    val title: String,
    val description: String,
    val avgPrice: Int? = null,
    val weight: Float,
)
