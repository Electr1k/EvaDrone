package ru.trifonov.evadrone.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.dto.Body
import ru.trifonov.evadrone.dto.Motors

class BodyAdapter (
    private var airCrewList: ArrayList<Body>,
): RecyclerView.Adapter<BodyAdapter.AirScrewViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AirScrewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.component_item, parent,false)
        return AirScrewViewHolder(view)
    }
    override fun getItemCount(): Int {
        return airCrewList.size
    }

    override fun onBindViewHolder(holder: AirScrewViewHolder, position: Int) {

        holder.title.text = "Название: ${airCrewList[position].title}"
        holder.subTitle.text = "Материал: ${airCrewList[position].material}"
        holder.removeBtn.setOnClickListener {
            airCrewList.removeAt(position)
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