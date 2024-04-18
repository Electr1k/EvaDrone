package ru.trifonov.evadrone.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.adpter.ComponentTypeAdapter
import ru.trifonov.evadrone.adpter.catalog.AirScrewsCatalogAdapter
import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attrubute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Component
import ru.trifonov.evadrone.dto.ComponentType
import ru.trifonov.evadrone.dto.Motors


class ListComponents : Fragment() {
    private lateinit var componentsRV: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_components, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        componentsRV = view.findViewById(R.id.rv)
        view.findViewById<TextView>(R.id.title).setText("Корпус")
        val id = arguments?.getInt("id")
        componentsRV.adapter = AirScrewsCatalogAdapter(getComponentsByTypeId(id!!))

    }
    private fun getComponentsByTypeId(id: Int): ArrayList<Component>{
        return when (id){
            0 -> arrayListOf(
                AirScrew(1, "Винт АФП-324", description = "", 424, 0.1f,20f),
                AirScrew(2, "Винт АФП-324", description = "", 424, 0.1f,20f),
            )
            1 -> arrayListOf(
                Motors(3, "Привод F37-43", description = "", 424, 0.3f, 4.4f, 0.4f, 4535),
                Motors(4, "Привод F37-43", description = "", 424, 0.3f, 4.4f, 0.4f, 5435),
                Motors(4, "Привод F37-43", description = "", 424, 0.3f, 4.4f, 0.4f, 5435),
            )
            2 -> arrayListOf(
                Body(id = 5, title = "Корпус титан", description = "", 1000, 4f, "Титан", 4),
                Body(id = 6, title = "Корпус титан", description = "", 1000, 4f, "Титан", 4)
            )
            3 -> arrayListOf(
                Accumulator(0, "Аккумулятор ТГА-314", description = "", 424, 1.1f, voltOut = 5.2f, amperOut = 35f),
                Accumulator(0, "Аккумулятор ТГА-314", description = "", 424, 1.1f, voltOut = 5.2f, amperOut = 35f),
                Accumulator(0, "Аккумулятор ТГА-314", description = "", 424, 1.1f, voltOut = 5.2f, amperOut = 35f),

            )
            4 -> arrayListOf(
                Attrubute(id = 0, title = "Камера GO PRO", "",4000, weight = 0.3f),
                Attrubute(id = 0, title = "Камера GO PRO", "",4000, weight = 0.3f)
            )
            else -> arrayListOf()
        }
    }

}