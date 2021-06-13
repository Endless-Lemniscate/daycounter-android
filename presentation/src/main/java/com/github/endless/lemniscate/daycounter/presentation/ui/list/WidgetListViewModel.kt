package com.github.endless.lemniscate.daycounter.presentation.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository
import com.github.endless.lemniscate.daycounter.domain.usecases.GetAllWidgetsUseCase
import com.github.endless.lemniscate.daycounter.presentation.App
import javax.inject.Inject

class WidgetListViewModel: ViewModel() {

    @Inject
    lateinit var getAllWidgetsUseCase: GetAllWidgetsUseCase

    init {
        // Inject repository
        App.applicationComponent.inject(this)
    }

    private val _allWidgets = getAllWidgetsUseCase.get().asLiveData()
    val allWidgets: LiveData<List<Widget>> = _allWidgets

}