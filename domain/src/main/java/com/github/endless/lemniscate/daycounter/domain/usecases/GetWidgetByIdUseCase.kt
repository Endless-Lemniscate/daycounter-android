package com.github.endless.lemniscate.daycounter.domain.usecases

import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository

class GetWidgetByIdUseCase(private val widgetRepository: WidgetRepository) {

    fun get(widgetId: Int): Widget {
        return widgetRepository.getWidgetById(widgetId)
    }
}