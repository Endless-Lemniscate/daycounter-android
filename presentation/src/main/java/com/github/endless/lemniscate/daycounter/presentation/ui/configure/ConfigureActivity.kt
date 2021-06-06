package com.github.endless.lemniscate.daycounter.presentation.ui.configure

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import androidx.activity.viewModels
import com.github.endless.lemniscate.daycounter.R
import com.github.endless.lemniscate.daycounter.databinding.ActivityConfigureBinding
import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.models.WidgetShape
import java.util.*

class ConfigureActivity: AppCompatActivity() {

    private lateinit var binding: ActivityConfigureBinding
    private val viewModel: ConfigureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appWidgetId = intent?.extras?.getInt(
            AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID
        ) ?: AppWidgetManager.INVALID_APPWIDGET_ID

        binding.idHolder.text = appWidgetId.toString()

        val appWidgetManager: AppWidgetManager = AppWidgetManager.getInstance(this)
        RemoteViews(packageName, R.layout.example_appwidget).also { views->
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }

        binding.buttonAddWidget.setOnClickListener {
            val resultValue = Intent().apply {
                putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            }
            val widget = Widget(
                id = appWidgetId,
                title = "title",
                shape = WidgetShape.Ellipse,
                color = 1,
                date = Date()
            )
            viewModel.createWidget(widget)
            setResult(Activity.RESULT_OK, resultValue)
            finish()
        }
    }
}