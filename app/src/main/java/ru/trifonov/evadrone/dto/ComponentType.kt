package ru.trifonov.evadrone.dto

import android.content.ClipDescription
import android.graphics.drawable.Drawable

data class ComponentType(
    val id: Int,
    val title: String,
    val icon: Drawable
)
