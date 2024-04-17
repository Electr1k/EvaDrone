package ru.trifonov.evadrone.dto

class Motors(
    id: Int, title:
    String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    needVolt: Float,
    needAmper: Float,
    val speedCycle: Int,
): Component(id, title, description, avgPrice, weight, needVolt, needAmper)