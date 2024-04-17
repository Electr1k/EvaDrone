package ru.trifonov.evadrone.dto

class Attrubute(
    id: Int,
    title: String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    needVolt: Float = 0f,
    needAmper: Float = 0f,
): Component(id, title, description, avgPrice, weight, needVolt, needAmper)