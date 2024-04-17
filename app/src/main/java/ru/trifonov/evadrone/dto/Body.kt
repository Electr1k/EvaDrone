package ru.trifonov.evadrone.dto

class Body(
    id: Int, title:
    String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    val material: String,
    val countAirScrews: Int
): Component(id, title, description, avgPrice, weight)