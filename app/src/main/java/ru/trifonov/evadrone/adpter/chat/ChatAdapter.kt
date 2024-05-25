package ru.trifonov.evadrone.adpter.chat

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.dto.Message

class ChatAdapter (
    private var messagesList: ArrayList<Message>,
    private var context: Context
): RecyclerView.Adapter<ChatAdapter.ComponentViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComponentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.message_item, parent,false)
        return ComponentViewHolder(view)
    }
    override fun getItemCount(): Int {
        return messagesList.size
    }

    override fun onBindViewHolder(holder: ComponentViewHolder, position: Int) {

        holder.linear.setPadding(if (messagesList[position].userId == 0) 50 else 0,0,if (messagesList[position].userId == 0) 0 else 50,0)
        holder.linear.gravity = if (messagesList[position].userId == 0) Gravity.END else Gravity.START
        holder.message.text = messagesList[position].message
        holder.message.setTextColor(context.getColor(if (messagesList[position].userId == 0) R.color.white else R.color.black))
        holder.card.setCardBackgroundColor(context.getColor(if (messagesList[position].userId == 0) R.color.blue else R.color.white))
    }
    fun sendMessage(m: Message){
        messagesList.add(m)
        notifyDataSetChanged()
    }
    class ComponentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val message: TextView
        val card: CardView
        val linear: LinearLayout
        init {
            message = itemView.findViewById(R.id.message)
            card = itemView.findViewById(R.id.card)
            linear = itemView.findViewById(R.id.linear)
        }
    }
}