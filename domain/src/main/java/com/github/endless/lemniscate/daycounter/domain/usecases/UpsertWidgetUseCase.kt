package com.github.endless.lemniscate.daycounter.domain.usecases

import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository
import javax.inject.Inject

class UpsertWidgetUseCase @Inject constructor(private val widgetRepository: WidgetRepository) {

    suspend fun upsert(widget: Widget) {
        widgetRepository.upsertWidget(widget)
    }
}