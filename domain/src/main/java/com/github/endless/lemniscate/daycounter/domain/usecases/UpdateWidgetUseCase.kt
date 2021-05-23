package com.github.endless.lemniscate.daycounter.domain.usecases

import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository

class UpdateWidgetUseCase(private val widgetRepository: WidgetRepository) {

    suspend fun update(widget: Widget) {
        widgetRepository.upsertWidget(widget)
    }
}