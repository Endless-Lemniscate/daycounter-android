package com.github.endless.lemniscate.daycounter.domain.repositories

import com.github.endless.lemniscate.daycounter.domain.models.Widget

interface WidgetRepository {
    fun getWidgetById(id: Int): Widget
    suspend fun upsertWidget(widget: Widget)
    suspend fun deleteWidget(widget: Widget)
}