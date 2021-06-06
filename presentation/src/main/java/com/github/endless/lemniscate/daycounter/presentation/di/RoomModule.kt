package com.github.endless.lemniscate.daycounter.presentation.di

import android.content.Context
import androidx.room.Room
import com.github.endless.lemniscate.daycounter.data.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ContextModule::class])
class RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "application_db"
    ).build()

    @Singleton
    @Provides
    fun provideWidgetDao(db: AppDatabase) = db.widgetDao()
}