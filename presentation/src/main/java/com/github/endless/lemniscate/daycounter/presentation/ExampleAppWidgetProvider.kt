package com.github.endless.lemniscate.daycounter.presentation

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.github.endless.lemniscate.daycounter.R
import java.util.*

class ExampleAppWidgetProvider: AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager,
                          appWidgetIds: IntArray?) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        val time = Calendar.getInstance().time.time

        appWidgetIds?.forEach { appWidgetId ->
            val remoteViews = RemoteViews(context.packageName, R.layout.example_appwidget)

            val pendingIntent: PendingIntent = Intent(context, MainActivity::class.java)
                .let { intent ->
                    PendingIntent.getActivity(context, 0, intent, 0)
                }
            remoteViews.setOnClickPendingIntent(R.id.root_view, pendingIntent)



            val string = "$time, $appWidgetId"
            remoteViews.setTextViewText(R.id.cool, string)

            appWidgetManager.updateAppWidget(appWidgetId, remoteViews)
        }

    }

}