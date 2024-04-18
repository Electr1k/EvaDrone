package ru.trifonov.evadrone.fragment

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ru.trifonov.evadrone.R
import ru.trifonov.evadrone.adpter.ComponentTypeAdapter
import ru.trifonov.evadrone.di.CatalogService
import ru.trifonov.evadrone.dto.ComponentType


class Catalog : Fragment() {
    private lateinit var catalogService: CatalogService
    private lateinit var componentsRV: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.catalog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catalogService = CatalogService.getInstance(requireContext())
        componentsRV = view.findViewById(R.id.rv)

        componentsRV.adapter = ComponentTypeAdapter(catalogService.getComponentTypes()!!, findNavController())
    }

}