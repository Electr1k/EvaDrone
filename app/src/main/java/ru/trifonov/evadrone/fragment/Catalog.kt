package ru.trifonov.evadrone.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.adpter.ComponentTypeAdapter
import ru.trifonov.evadrone.dto.ComponentType


class Catalog : Fragment() {
    private lateinit var componentsRV: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.catalog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        componentsRV = view.findViewById(R.id.rv)

        componentsRV.adapter = ComponentTypeAdapter(arrayListOf(
            ComponentType(id = 0, title = "Винты", icon = resources.getDrawable(R.drawable.airscrew_icon)),
            ComponentType(id = 1, title = "Двигатели", icon = resources.getDrawable(R.drawable.motor_icon)),
            ComponentType(id = 2, title = "Корпус", icon = resources.getDrawable(R.drawable.drone_body_icon)),
            ComponentType(id = 3, title = "Питание", icon = resources.getDrawable(R.drawable.accumulator_icon)),
            ComponentType(id = 4, title = "Другое", icon = resources.getDrawable(R.drawable.camera_icon)),
        ), findNavController())
    }

}