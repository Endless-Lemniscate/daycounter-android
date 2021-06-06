package com.github.endless.lemniscate.daycounter.presentation.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.github.endless.lemniscate.daycounter.databinding.FragmentWidgetsListBinding
import javax.inject.Inject

class WidgetsListFragment: Fragment() {
    private var _binding: FragmentWidgetsListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WidgetListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentWidgetsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.widgetsRecycler.adapter = WidgetListAdapter()

        viewModel.allWidgets.observe(viewLifecycleOwner, { widgetsList ->
            (binding.widgetsRecycler.adapter as WidgetListAdapter).setData(widgetsList)
        })
    }

}