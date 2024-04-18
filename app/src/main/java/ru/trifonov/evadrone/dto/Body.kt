package ru.trifonov.evadrone.dto

class Body(
    id: Int, title:
    String,
    description: String,
    avgPrice: Int? = null,
    weight: Float,
    val material: String,
    val countAirScrews: Int
): Component(id, title, description, avgPrice, weight){
    override fun getAttributes(): String {
        return "Масса: $weight кг\n" +
            "Материал: $material\n" +
            "Количество винтов: $countAirScrews"
    }

    override fun getFavoriteAttributes(): String {
        return "Материал: $material\n" +
        "Количество винтов: $countAirScrews"
    }

}