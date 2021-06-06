package com.github.endless.lemniscate.daycounter.presentation.ui.configure

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.usecases.UpsertWidgetUseCase
import com.github.endless.lemniscate.daycounter.presentation.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ConfigureViewModel: ViewModel() {

    @Inject
    lateinit var upsertWidgetUseCase: UpsertWidgetUseCase

    private val _id = MutableLiveData<Int>()
    val id: LiveData<Int> get() = _id

    private val _title = MutableLiveData<String>()
    val title: LiveData<String> get() = _title

    private val _date = MutableLiveData<Int>()
    val date: LiveData<Int> get() = _date

    init {
        App.applicationComponent.inject(this)
    }

    fun updateId(id: Int) {
        _id.value = id
    }

    fun updateTitle(title: String) {
        _title.value = title
    }

    fun updateDate(date: Int) {
        _date.value = date
    }

    fun createWidget(widget: Widget) = viewModelScope.launch(Dispatchers.IO) {
        upsertWidgetUseCase.upsert(widget)
    }
}