package com.github.endless.lemniscate.daycounter.domain.usecases

import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository
import javax.inject.Inject

class DeleteWidgetUseCase @Inject constructor(private val widgetRepository: WidgetRepository) {

    suspend fun deleteWidgetById(id: Int) {
        widgetRepository.deleteWidgetById(id)
    }
}