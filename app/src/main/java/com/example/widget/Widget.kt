package com.example.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.RequiresApi

class Widget: AppWidgetProvider() {

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onUpdate(
        context: Context?,
        appWidgetManager: AppWidgetManager?,
        appWidgetIds: IntArray?,
    ) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        if (appWidgetIds == null) return
        if (appWidgetManager == null) return
        if (context == null) return

        val viewMapping = RemoteViews(
            context.packageName,
            R.layout.widget_medium
        )
        viewMapping.setInt(R.id.widget_bg, "setImageAlpha", 45)

        for (appWidgetId in appWidgetIds) {
            appWidgetManager.updateAppWidget(appWidgetId, RemoteViews(viewMapping))
        }
    }

}