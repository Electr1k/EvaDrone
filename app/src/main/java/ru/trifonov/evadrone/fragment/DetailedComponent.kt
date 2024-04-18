package ru.trifonov.evadrone.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.di.CatalogService
import ru.trifonov.evadrone.di.ConstructorService
import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attribute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Motor


class DetailedComponent : Fragment() {
    private lateinit var catalogService: CatalogService
    private lateinit var constructorService: ConstructorService
    private lateinit var title: TextView
    private lateinit var attributes: TextView
    private lateinit var description: TextView
    private lateinit var addBtn: Button
    private lateinit var icon: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detailed_component_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        constructorService = ConstructorService.getInstance()
        catalogService = CatalogService.getInstance(requireContext())
        title = view.findViewById(R.id.title)
        attributes = view.findViewById(R.id.attr)
        description = view.findViewById(R.id.description)
        addBtn = view.findViewById(R.id.addBtn)
        icon = view.findViewById(R.id.icon)
        val id = arguments?.getInt("id")
        val component = catalogService.getComponentById(id!!)
        title.text = component!!.title
        attributes.text = component.getAttributes()
        description.text = component.description
        icon.setImageDrawable(catalogService.getComponentTypeById(component.typeId)!!.icon)
        addBtn.setOnClickListener {
            when (component) {
                is Body ->{
                    constructorService.setBody(component)
                }
                is AirScrew -> {
                    constructorService.addAirScrew(component)
                    println(constructorService.getAirScrews())
                }
                is Motor -> {
                    constructorService.addMotor(component)
                }
                is Accumulator -> {
                    constructorService.addAccumulator(component)
                }
                is Attribute -> {
                    constructorService.addAttribute(component)
                }
            }
        }
    }

}