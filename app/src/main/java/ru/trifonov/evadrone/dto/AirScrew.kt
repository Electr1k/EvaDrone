package ru.trifonov.evadrone.dto

class AirScrew(
    id: Int,
    title: String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    val length: Float
): Component(id, title, description, avgPrice, weight)