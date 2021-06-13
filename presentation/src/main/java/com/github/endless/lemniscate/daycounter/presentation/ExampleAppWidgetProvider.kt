package com.github.endless.lemniscate.daycounter.presentation

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.github.endless.lemniscate.daycounter.R
import com.github.endless.lemniscate.daycounter.domain.usecases.DeleteWidgetUseCase
import com.github.endless.lemniscate.daycounter.domain.usecases.GetWidgetByIdUseCase
import com.github.endless.lemniscate.daycounter.presentation.ui.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class ExampleAppWidgetProvider: AppWidgetProvider() {

    @Inject
    lateinit var deleteWidgetUseCase: DeleteWidgetUseCase

    @Inject
    lateinit var getWidgetByIdUseCase: GetWidgetByIdUseCase

    init {
        App.applicationComponent.inject(this)
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager,
                          appWidgetIds: IntArray) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        //val time = Calendar.getInstance().time.time

        appWidgetIds.forEach { id ->
            val view = RemoteViews(context.packageName, R.layout.example_appwidget)

            val pendingIntent: PendingIntent = Intent(context, MainActivity::class.java)
                .let { intent ->
                    PendingIntent.getActivity(context, 0, intent, 0)
                }
            view.setOnClickPendingIntent(R.id.root_view, pendingIntent)

            // Set days
            view.setTextViewText(R.id.days, id.toString())

            appWidgetManager.updateAppWidget(id, view)
        }

    }

    override fun onDeleted(context: Context?, appWidgetIds: IntArray) {
        super.onDeleted(context, appWidgetIds)
        GlobalScope.launch(Dispatchers.IO) {
            appWidgetIds.forEach { id ->
                deleteWidgetUseCase.deleteWidgetById(id)
            }
        }
    }

}