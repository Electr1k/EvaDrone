package ru.trifonov.evadrone.dto

class Attrubute(
    id: Int,
    title: String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
): Component(id, title, description, avgPrice, weight)