package com.github.endless.lemniscate.daycounter.data.repositories

import com.github.endless.lemniscate.daycounter.data.db.WidgetDao
import com.github.endless.lemniscate.daycounter.data.models.toData
import com.github.endless.lemniscate.daycounter.data.models.toDomain
import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WidgetRepositoryImpl @Inject constructor(private val widgetDao: WidgetDao): WidgetRepository {

    override fun getAllWidgets(): Flow<List<Widget>> {
        return widgetDao.getAllWidgets().map { it.map { widget -> widget.toDomain } }
    }

    override fun getWidgetById(id: Int): Widget {
        return widgetDao.getWidgetById(id).toDomain
    }

    override suspend fun upsertWidget(widget: Widget) {
        widgetDao.upsertWidget(widget.toData)
    }

    override suspend fun deleteWidget(widget: Widget) {
        widgetDao.deleteWidget(widget.toData)
    }
}