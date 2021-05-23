package com.github.endless.lemniscate.daycounter.domain.usecases

import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository

class DeleteWidgetUseCase(private val widgetRepository: WidgetRepository) {

    suspend fun delete(widget: Widget) {
        widgetRepository.deleteWidget(widget)
    }
}