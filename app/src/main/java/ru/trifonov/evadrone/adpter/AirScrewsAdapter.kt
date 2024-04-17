package ru.trifonov.evadrone.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.dto.AirScrew

class AirScrewsAdapter (
    private var airCrewList: ArrayList<AirScrew>,
): RecyclerView.Adapter<AirScrewsAdapter.AirScrewViewHolder>() {
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
        holder.countCycle.text = "Длинна: ${airCrewList[position].length} м."
        holder.removeBtn.setOnClickListener {
            airCrewList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    class AirScrewViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView
        val countCycle: TextView
        val removeBtn: Button
        init {
            title = itemView.findViewById(R.id.title)
            countCycle = itemView.findViewById(R.id.subTitle)
            removeBtn = itemView.findViewById(R.id.delete)
        }
    }
}