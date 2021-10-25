package com.github.endless.lemniscate.daycounter.domain.repositories

import com.github.endless.lemniscate.daycounter.domain.models.Widget
import kotlinx.coroutines.flow.Flow

interface WidgetRepository {
    fun getAllWidgets(): Flow<List<Widget>>
    fun getWidgetById(id: Int): Widget?
    suspend fun upsertWidget(widget: Widget)
    suspend fun deleteWidgetById(id: Int)
}