package com.github.endless.lemniscate.daycounter.domain.usecases

import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository
import javax.inject.Inject

class GetAllWidgetsUseCase @Inject constructor(private val widgetRepository: WidgetRepository) {

    fun get(widgetId: Int): Widget {
        return widgetRepository.getWidgetById(widgetId)
    }
}