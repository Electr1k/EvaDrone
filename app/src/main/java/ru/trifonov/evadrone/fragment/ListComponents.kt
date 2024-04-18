package ru.trifonov.evadrone.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.adpter.catalog.CatalogComponentAdapter
import ru.trifonov.evadrone.di.CatalogService
import ru.trifonov.evadrone.dto.Component


class ListComponents : Fragment() {
    private lateinit var catalogService: CatalogService
    private lateinit var componentsRV: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_components_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catalogService = CatalogService.getInstance(requireContext())
        componentsRV = view.findViewById(R.id.rv)
        val id = arguments?.getInt("id")

        view.findViewById<TextView>(R.id.title).text = catalogService.getComponentTypeById(catalogService.getComponentById(id!!)!!.typeId)!!.title
        componentsRV.adapter = CatalogComponentAdapter(catalogService.getComponentsByTypeId(id) as ArrayList<Component>, findNavController())
    }


}