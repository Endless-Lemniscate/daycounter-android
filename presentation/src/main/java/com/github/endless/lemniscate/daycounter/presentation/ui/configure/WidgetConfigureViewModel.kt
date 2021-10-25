package com.github.endless.lemniscate.daycounter.presentation.ui.configure

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.usecases.GetWidgetByIdUseCase
import com.github.endless.lemniscate.daycounter.domain.usecases.UpsertWidgetUseCase
import com.github.endless.lemniscate.daycounter.presentation.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class WidgetConfigureViewModel: ViewModel() {

    @Inject
    lateinit var upsertWidgetUseCase: UpsertWidgetUseCase

    @Inject
    lateinit var getWidgetByIdUseCase: GetWidgetByIdUseCase

    private val _widget = MutableLiveData<Widget>()
    val widget: LiveData<Widget> get() = _widget

    init {
        App.applicationComponent.inject(this)
    }

    fun passWidgetId(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getWidgetByIdUseCase.get(id)?.let {
                _widget.postValue(it)
            }
        }
    }

    fun updateTitle(title: String) {
        _widget.value?.title = title
    }

    fun updateDate(date: Date) {
        _widget.value?.date = date
    }

    fun upsertWidget(widget: Widget) = viewModelScope.launch(Dispatchers.IO) {
        upsertWidgetUseCase.upsert(widget)
    }
}