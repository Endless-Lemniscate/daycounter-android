package com.github.endless.lemniscate.daycounter.data.repositories

import com.github.endless.lemniscate.daycounter.data.db.WidgetDao
import com.github.endless.lemniscate.daycounter.data.models.toRomWidget
import com.github.endless.lemniscate.daycounter.data.models.toWidget
import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WidgetRepositoryImpl @Inject constructor(private val widgetDao: WidgetDao): WidgetRepository {

    override fun getAllWidgets(): Flow<List<Widget>> {
        return widgetDao.getAllWidgets().map {
            it.map { widget ->
                widget.toWidget()
            }
        }
    }

    override fun getWidgetById(id: Int): Widget? {
        return widgetDao.getWidgetById(id)?.toWidget()
    }

    override suspend fun upsertWidget(widget: Widget) {
        widgetDao.upsertWidget(widget.toRomWidget())
    }

    override suspend fun deleteWidgetById(id: Int) {
        widgetDao.deleteWidget(id)
    }
}