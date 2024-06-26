package ru.trifonov.evadrone.dto

class Accumulator(
    id: Int,
    title: String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    typeId: Int = 3,
    val voltOut: Float,
    val amperOut: Float,
): Component(id, title, description, avgPrice, weight, typeId = typeId) {
    override fun getAttributes(): String {
        return "Масса: $weight кг\n" +
            "ЭДС: $voltOut В.\n" +
            "Сила тока на выходе: $amperOut А."
    }

    override fun getFavoriteAttributes(): String {
        return "ЭДС: $voltOut В.\n" +
                "Сила тока на выходе: $amperOut А."
    }
}