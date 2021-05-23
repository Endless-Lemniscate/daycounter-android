package com.github.endless.lemniscate.daycounter.domain.usecases

import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository

class AddWidgetUseCase(private val widgetRepository: WidgetRepository) {

    suspend fun add(widget: Widget) {
        widgetRepository.upsertWidget(widget)
    }
}