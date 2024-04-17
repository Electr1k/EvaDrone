package ru.trifonov.evadrone.dto

class Motors(
    id: Int, title:
    String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    val needVolt: Float,
    val needAmper: Float,
    val speedCycle: Int,
): Component(id, title, description, avgPrice, weight)