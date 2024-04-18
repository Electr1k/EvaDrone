package ru.trifonov.evadrone.repository

import android.content.Context
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.domain.repository.ComponentsRepository
import ru.trifonov.evadrone.dto.Component
import ru.trifonov.evadrone.dto.ComponentType

open class ComponentsRepositoryImpl(private val context: Context): ComponentsRepository {
    override fun getComponentTypes(): List<ComponentType>? {
        return listOf(
            ComponentType(id = 0, title = "Винты", icon = context.getDrawable(R.drawable.airscrew_icon)!!),
            ComponentType(id = 1, title = "Двигатели", icon = context.getDrawable(R.drawable.motor_icon)!!),
            ComponentType(id = 2, title = "Корпус", icon = context.getDrawable(R.drawable.drone_body_icon)!!),
            ComponentType(id = 3, title = "Питание", icon = context.getDrawable(R.drawable.accumulator_icon)!!),
            ComponentType(id = 4, title = "Другое", icon = context.getDrawable(R.drawable.camera_icon)!!)
        )
    }


    override fun getComponentTypeById(id: Int): ComponentType? {
        return listOf(
            ComponentType(id = 0, title = "Винты", icon = context.getDrawable(R.drawable.airscrew_icon)!!),
            ComponentType(id = 1, title = "Двигатели", icon = context.getDrawable(R.drawable.motor_icon)!!),
            ComponentType(id = 2, title = "Корпус", icon = context.getDrawable(R.drawable.drone_body_icon)!!),
            ComponentType(id = 3, title = "Питание", icon = context.getDrawable(R.drawable.accumulator_icon)!!),
            ComponentType(id = 4, title = "Другое", icon = context.getDrawable(R.drawable.camera_icon)!!)
        ).find { it.id == id }
    }

    override fun getComponents(): List<Component> {
        return TestObject.components
    }

    override fun getComponentById(id: Int): Component? {
        return TestObject.components.find { it.id == id }
    }

    override fun getComponentsByTypeId(id: Int): List<Component> {
        return TestObject.components.filter { it.typeId == id }
    }
}