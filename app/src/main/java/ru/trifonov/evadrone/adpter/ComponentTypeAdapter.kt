package ru.trifonov.evadrone.adpter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.dto.AirScrew
import ru.trifonov.evadrone.dto.ComponentType

class ComponentTypeAdapter (
    private var typeList: List<ComponentType>,
    private var navController: NavController
): RecyclerView.Adapter<ComponentTypeAdapter.ComponentViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.component_type_item, parent,false)
        return ComponentViewHolder(view)
    }
    override fun getItemCount(): Int {
        return typeList.size
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {
        holder.title.text = typeList[position].title
        val bundle = Bundle().also {
            it.putInt("id", typeList[position].id)
        }
        holder.card.setOnClickListener { navController.navigate(R.id.action_catalog_to_list_components, bundle) }
        holder.icon.setImageDrawable(typeList[position].icon)
    }

    class ComponentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView
        val icon: ImageView
        val card: CardView
        init {
            title = itemView.findViewById(R.id.title)
            icon = itemView.findViewById(R.id.icon)
            card = itemView.findViewById(R.id.component_type_item)
        }
    }
}