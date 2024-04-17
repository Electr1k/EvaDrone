package ru.trifonov.evadrone.dto

class Accumulator(
    id: Int, title:
    String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    val voltOut: Float,
    val amperOut: Float,
): Component(id, title, description, avgPrice, weight)