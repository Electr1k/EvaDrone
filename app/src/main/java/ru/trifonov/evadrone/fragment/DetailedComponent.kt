package ru.trifonov.evadrone.fragment

import android.app.AlertDialog
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.adpter.constructor.ConstructorComponentAdapter
import ru.trifonov.evadrone.di.CatalogService
import ru.trifonov.evadrone.di.ConstructorService
import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attribute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Component
import ru.trifonov.evadrone.dto.Motor


class DetailedComponent : Fragment() {
    private lateinit var catalogService: CatalogService
    private lateinit var constructorService: ConstructorService
    private lateinit var title: TextView
    private lateinit var attributes: TextView
    private lateinit var description: TextView
    private lateinit var avgPrice: TextView
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
        avgPrice = view.findViewById(R.id.avgPrice)
        icon = view.findViewById(R.id.icon)
        val id = arguments?.getInt("id")
        val component = catalogService.getComponentById(id!!)
        title.text = component!!.title
        attributes.text = component.getAttributes()
        description.text = component.description
        avgPrice.text = "Средняя цена: ${component.avgPrice} руб."
        icon.setImageDrawable(
            when (component) {
                is Body ->{
                    resources.getDrawable(R.drawable.body)
                }
                is AirScrew -> {
                    resources.getDrawable(R.drawable.airscrew)
                }
                is Motor -> {
                    resources.getDrawable(R.drawable.motor)
                }
                is Accumulator -> {
                    resources.getDrawable(R.drawable.accumulator)
                }
                is Attribute -> {
                    resources.getDrawable(R.drawable.attr)
                }
                else -> { catalogService.getComponentTypeById(component.typeId)!!.icon}
            }
        )
        addBtn.setOnClickListener {
            when (component) {
                is Body ->{
                    constructorService.setBody(component)
                    if (constructorService.getBody() != null) dialogBuilder(listOf(constructorService.getBody()!!))
                }
                is AirScrew -> {
                    constructorService.addAirScrew(component)
                    dialogBuilder(constructorService.getAirScrews())
                }
                is Motor -> {
                    constructorService.addMotor(component)
                    dialogBuilder(constructorService.getMotors())
                }
                is Accumulator -> {
                    constructorService.addAccumulator(component)
                    dialogBuilder(constructorService.getAccumulators())
                }
                is Attribute -> {
                    constructorService.addAttribute(component)
                    dialogBuilder(constructorService.getAttributes())
                }
            }
        }
    }

    private fun dialogBuilder(componentsList: List<Component>){
        val dialog = AlertDialog.Builder(requireContext()).create()

        dialog.window?.setBackgroundDrawable(
            AppCompatResources.getDrawable(
                requireContext(),
                R.drawable.dialog_rounded_background
            )
        )
        val alertDialogView = dialog.window!!.decorView
        val dialogView = layoutInflater.inflate(R.layout.selected_components_list, null)
        dialogView.findViewById<TextView>(R.id.title_type_component).apply {
            text = "Компонент выбран!\nТекущие компоненты:"
            textSize = 18f
        }
        dialogView.findViewById<RecyclerView>(R.id.rv).adapter = ConstructorComponentAdapter(componentsList.toMutableList())
        dialogView.findViewById<Button>(R.id.addBtn).apply {
            text = "Закрыть"
        }.setOnClickListener {
            dialog.cancel()
        }
        val viewGroup = alertDialogView as ViewGroup
        viewGroup.addView(dialogView)
        dialog.show()
    }
}