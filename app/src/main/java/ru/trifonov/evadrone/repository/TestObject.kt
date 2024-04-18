package ru.trifonov.evadrone.repository

import android.annotation.SuppressLint

import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attribute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Motor

@SuppressLint("StaticFieldLeak")
object TestObject {




    val components = listOf(
        AirScrew(id = 0, title = "Винт АФП-324", description = "писание для винта пыпрпра", avgPrice = 139, weight = 0.1f, length = 20f),
        AirScrew(id = 1, title = "Винт Abo", description = "Описание для винта пыпрпра", avgPrice = 99, weight = 0.15f, length = 25f),
        Motor(id = 2, title = "Привод F37-43", description =  "", avgPrice = 599, weight = 0.2f, needVolt = 4.4f, needAmper = 0.3f, speedCycle = 1600),
        Motor(id = 3, title = "Привод F31-4b", description = "", avgPrice = 399, weight = 0.3f, needVolt = 3.9f, needAmper = 0.8f, speedCycle = 2000),
        Motor(id = 4, title = "Привод F96", description = "", avgPrice = 456, weight = 0.25f, needVolt = 2f, needAmper = 0.6f, speedCycle = 2500),
        Body(id = 5, title = "Корпус титан", description = "", avgPrice = 1000, weight = 4f, material = "Титан", countAirScrews = 4),
        Body(id = 6, title = "Корпус титан", description = "", avgPrice = 1000, weight = 4f, material = "Титан", countAirScrews = 4),
        Accumulator(id = 7, title = "Аккумулятор ТГА-314", description = "", avgPrice = 1004, weight = 1.1f, voltOut = 12f, amperOut = 4f),
        Accumulator(id = 8, title = "Аккумулятор Л-15", description = "", avgPrice = 924, weight = 2.1f, voltOut = 24f, amperOut = 5f),
        Accumulator(id = 9, title = "Аккумулятор ТПыр-514", description = "", avgPrice = 673, weight = 1.6f, voltOut = 18f, amperOut = 7.5f),
        Attribute(id = 10, title = "Камера GO PRO 1", description = "", avgPrice = 9999, weight = 1.3f),
        Attribute(id = 11, title = "Камера GO PRO 2", description = "", avgPrice = 12000, weight = 1f)

    )
}