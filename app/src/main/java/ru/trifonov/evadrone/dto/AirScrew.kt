package ru.trifonov.evadrone.dto

class AirScrew(
    id: Int,
    title: String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    val length: Float
): Component(id, title, description, avgPrice, weight) {
    override fun getAttributes(): String {
        return "Длинна: $length м.\n" +
            "Масса: $weight кг"
    }

    override fun getFavoriteAttributes(): String {
        return "Длинна: $length м."
    }
}