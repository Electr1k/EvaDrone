package ru.trifonov.evadrone.adpter.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attrubute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Component
import ru.trifonov.evadrone.dto.Motors

class AirScrewsCatalogAdapter (
    private var componentsList: ArrayList<Component>,
): RecyclerView.Adapter<AirScrewsCatalogAdapter.AirScrewViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AirScrewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.air_screw_item, parent,false)
        return AirScrewViewHolder(view)
    }
    override fun getItemCount(): Int {
        return componentsList.size
    }

    override fun onBindViewHolder(holder: AirScrewViewHolder, position: Int) {

        holder.title.text = componentsList[position].title
        holder.subtitle.text = when(componentsList[position]){
            is AirScrew ->{
                "Длинна: ${(componentsList[position] as AirScrew).length} м.\n" +
                "Масса: ${componentsList[position].weight} кг"
            }
            is Motors ->{
                "Масса: ${componentsList[position].weight} кг\n"
                "Скорость вращения: ${(componentsList[position] as Motors).speedCycle} об/мин\n" +
                "Напряжение: ${componentsList[position].needVolt} В.\n" +
                "Сила тока: ${componentsList[position].needAmper} A."
            }
            is Body -> {
                "Масса: ${componentsList[position].weight} кг\n" +
                "Материал: ${(componentsList[position] as Body).material}\n" +
                "Количество винтов: ${(componentsList[position] as Body).countAirScrews}"
            }
            is Accumulator ->{
                "Масса: ${componentsList[position].weight} кг\n" +
                "ЭДС: ${(componentsList[position] as Accumulator).voltOut}\n В." +
                "Сила тока на выходе: ${(componentsList[position] as Accumulator).amperOut} А."
            }
            is Attrubute ->{
                "Масса: ${componentsList[position].weight} кг\n" +
                "Напряжение: ${componentsList[position].needVolt} В.\n" +
                "Сила тока: ${componentsList[position].needAmper} A."
            }
            else -> ""
        }
        holder.avgPrice.text = "Средняя цена:\n${componentsList[position].avgPrice} р."
    }

    class AirScrewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView
        val avgPrice: TextView
        val subtitle: TextView

        init {
            title = itemView.findViewById(R.id.title)
            avgPrice = itemView.findViewById(R.id.avgPrice)
            subtitle = itemView.findViewById(R.id.subtitle)
        }
    }
}