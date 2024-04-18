package ru.trifonov.evadrone.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.trifonov.evadrone.R


class DetailedComponent : Fragment() {
    private lateinit var title: TextView
    private lateinit var attributes: TextView
    private lateinit var description: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detailed_component_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = view.findViewById(R.id.title)
        attributes = view.findViewById(R.id.attr)
        description = view.findViewById(R.id.description)
        val id = arguments?.getInt("id")
        title.text = "Id: $id"

    }

}