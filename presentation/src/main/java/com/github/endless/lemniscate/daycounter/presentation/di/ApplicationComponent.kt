package com.github.endless.lemniscate.daycounter.presentation.di

import com.github.endless.lemniscate.daycounter.presentation.ExampleAppWidgetProvider
import com.github.endless.lemniscate.daycounter.presentation.ui.configure.WidgetConfigureViewModel
import com.github.endless.lemniscate.daycounter.presentation.ui.list.WidgetListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, ContextModule::class, RoomModule::class])
interface ApplicationComponent {
    fun inject(widgetListViewModel: WidgetListViewModel)
    fun inject(widgetConfigureViewModel: WidgetConfigureViewModel)
    fun inject(exampleAppWidgetProvider: ExampleAppWidgetProvider)
}