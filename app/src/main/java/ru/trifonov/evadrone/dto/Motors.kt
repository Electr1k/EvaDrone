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
): Component(id, title, description, avgPrice, weight, needVolt, needAmper){

    override fun getAttributes(): String {
        return "Масса: $weight кг\n" +
            "Скорость вращения: $speedCycle об/мин\n" +
            "Напряжение: $needVolt В.\n" +
            "Сила тока: $needAmper A."
    }

    override fun getFavoriteAttributes(): String {
        return "Скорость вращения: $speedCycle об/мин\n"
    }
}