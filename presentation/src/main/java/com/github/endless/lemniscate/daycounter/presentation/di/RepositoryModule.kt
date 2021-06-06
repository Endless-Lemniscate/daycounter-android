package com.github.endless.lemniscate.daycounter.presentation.di

import com.github.endless.lemniscate.daycounter.data.db.WidgetDao
import com.github.endless.lemniscate.daycounter.data.repositories.WidgetRepositoryImpl
import com.github.endless.lemniscate.daycounter.domain.repositories.WidgetRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideWidgetRepository(widgetDao: WidgetDao): WidgetRepository {
        return WidgetRepositoryImpl(widgetDao)
    }
}