package ru.trifonov.evadrone.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.adpter.chat.ChatAdapter
import ru.trifonov.evadrone.dto.Message


class Chat : Fragment() {

    private lateinit var chatRV: RecyclerView
    private lateinit var sendBtn: ImageView
    private lateinit var message: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chat_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatRV = view.findViewById(R.id.chatRV)
        sendBtn = view.findViewById(R.id.sendBtn)
        message = view.findViewById(R.id.message)
        val messages = arrayListOf(
            Message(0, "Какой винт лучше взять?"),
            Message(1, "Для любительского квадрокоптера лучше взять AI-32"),
            Message(0, "А какая у него длина крыла?"),
            Message(1, "25 сантиметров")
        )
        chatRV.scrollToPosition(messages.size)
        val adapter= ChatAdapter(messages, requireContext())
        chatRV.adapter = adapter
        sendBtn.setOnClickListener {
            if (message.text.isNotEmpty()){
                adapter.sendMessage(Message(0, message.text.toString()))
                message.setText("")
            }
        }
    }

}