package ru.trifonov.evadrone.domain.repository

import ru.trifonov.evadrone.dto.Component
import ru.trifonov.evadrone.dto.ComponentType

interface ComponentsRepository {
    fun getComponentTypes(): List<ComponentType>?
    fun getComponentTypeById(id: Int): ComponentType?
    fun getComponents(): List<Component>?
    fun getComponentById(id: Int): Component?
    fun getComponentsByTypeId(id: Int): List<Component>?
}