package ru.trifonov.evadrone.adpter.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.dto.Component

class CatalogComponentAdapter (
    private var componentsList: ArrayList<Component>,
    private var navController: NavController
): RecyclerView.Adapter<CatalogComponentAdapter.ComponentViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.catalog_component_item, parent,false)
        return ComponentViewHolder(view)
    }
    override fun getItemCount(): Int {
        return componentsList.size
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {

        holder.title.text = componentsList[position].title
        holder.subtitle.text = componentsList[position].getAttributes()
        holder.avgPrice.text = "Средняя цена:\n${componentsList[position].avgPrice} р."
        holder.card.setOnClickListener {
            navController.navigate(R.id.action_list_components_to_detailed_component, Bundle().also { it.putInt("id", componentsList[position].id) })
        }
    }

    class ComponentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView
        val avgPrice: TextView
        val subtitle: TextView
        val card: CardView
        init {
            title = itemView.findViewById(R.id.title)
            avgPrice = itemView.findViewById(R.id.avgPrice)
            subtitle = itemView.findViewById(R.id.subtitle)
            card = itemView.findViewById(R.id.catalog_component_item)
        }
    }
}