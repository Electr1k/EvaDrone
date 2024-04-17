package ru.trifonov.evadrone.dto

class Body(
    id: Int, title:
    String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    val material: String,
): Component(id, title, description, avgPrice, weight)