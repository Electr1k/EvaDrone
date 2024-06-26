package ru.trifonov.evadrone.dto

class Attribute(
    id: Int,
    title: String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    needVolt: Float = 0f,
    needAmper: Float = 0f,
    typeId: Int = 4
): Component(id, title, description, avgPrice, weight, needVolt, needAmper, typeId = typeId) {
    override fun getAttributes(): String {
        return "Масса: $weight кг\n" +
            "Напряжение: $needVolt В.\n" +
            "Сила тока: $needAmper A."
    }

    override fun getFavoriteAttributes(): String {
        return "Масса: $weight кг\n"
    }
}