package com.github.endless.lemniscate.daycounter.domain.usecases

import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllWidgetsUseCase @Inject constructor(private val widgetRepository: WidgetRepository) {

    fun get(): Flow<List<Widget>> {
        return widgetRepository.getAllWidgets()
    }
}