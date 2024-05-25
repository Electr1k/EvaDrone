package ru.trifonov.evadrone.adpter.constructor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.di.ConstructorService
import ru.trifonov.evadrone.dto.Accumulator
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.Attribute
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Component
import ru.trifonov.evadrone.dto.Motor

class ConstructorComponentAdapter (
    private var components: MutableList<Component>,
    private val onRemove: () -> Unit = {}
): RecyclerView.Adapter<ConstructorComponentAdapter.AirScrewViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AirScrewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.component_item, parent,false)
        return AirScrewViewHolder(view)
    }
    override fun getItemCount(): Int {
        return components.size
    }

    override fun onBindViewHolder(holder: AirScrewViewHolder, position: Int) {

        holder.title.text = "Название: ${components[position].title}"
        holder.subTitle.text = components[position].getFavoriteAttributes()
        holder.removeBtn.setOnClickListener {
            val service = ConstructorService.getInstance()
            when (components[position]){
                is AirScrew -> {
                    service.removeAirScrew(components[position] as AirScrew)
                }
                is Motor -> {
                    service.removeMotor(components[position] as Motor)
                }
                is Body -> {
                    service.removeBody()
                }
                is Accumulator -> {
                    service.removeAccumulator(components[position] as Accumulator)
                }
                is Attribute -> {
                    service.removeAttribute(components[position] as Attribute)
                }
            }
            components.removeAt(position)
            onRemove()
            notifyDataSetChanged()
        }
    }

    class AirScrewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView
        val subTitle: TextView
        val removeBtn: Button
        init {
            title = itemView.findViewById(R.id.title)
            subTitle = itemView.findViewById(R.id.subTitle)
            removeBtn = itemView.findViewById(R.id.delete)
        }
    }
}