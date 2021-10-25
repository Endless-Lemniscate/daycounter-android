package com.github.endless.lemniscate.daycounter.presentation.ui.configure

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RemoteViews
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.github.endless.lemniscate.daycounter.R
import com.github.endless.lemniscate.daycounter.databinding.FragmentWidgetConfigureBinding

class WidgetConfigureFragment : Fragment() {

    private var _binding: FragmentWidgetConfigureBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WidgetConfigureViewModel by viewModels()
    private val args: WidgetConfigureFragmentArgs by navArgs()
    private val widgetId by lazy { args.widgetId }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.passWidgetId(widgetId)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentWidgetConfigureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOnclickListeners()
//        val widget = Widget(
//            id = widgetId,
//            title = "title",
//            shape = WidgetShape.Ellipse,
//            color = 1,
//            date = Date()
//        )
//        viewModel.upsertWidget(widget)
    }

    private fun initOnclickListeners() {
        binding.buttonAddWidget.setOnClickListener {
            updateWidgetOnDb()
        }
    }

    private fun updateWidgetOnDb() {
        val appWidgetManager: AppWidgetManager = AppWidgetManager.getInstance(requireContext())
        val remoteView = RemoteViews(requireContext().packageName, R.layout.example_appwidget)

        // Set days
        remoteView.setTextViewText(R.id.days, widgetId.toString())
        appWidgetManager.updateAppWidget(widgetId, remoteView)

        val resultValue = Intent().apply {
            putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, widgetId)
        }
        requireActivity().setResult(Activity.RESULT_OK, resultValue)
        requireActivity().finish()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}