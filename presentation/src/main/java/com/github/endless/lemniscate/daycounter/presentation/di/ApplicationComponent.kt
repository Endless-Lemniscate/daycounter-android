package com.github.endless.lemniscate.daycounter.presentation.di

import com.github.endless.lemniscate.daycounter.domain.usecases.GetAllWidgetsUseCase
import com.github.endless.lemniscate.daycounter.presentation.ui.configure.ConfigureViewModel
import com.github.endless.lemniscate.daycounter.presentation.ui.list.WidgetListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModule::class, ContextModule::class, RoomModule::class])
interface ApplicationComponent {
    fun inject(widgetListViewModel: WidgetListViewModel)
    fun inject(configureViewModel: ConfigureViewModel)
}