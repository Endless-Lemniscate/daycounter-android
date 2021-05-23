package com.github.endless.lemniscate.daycounter.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.endless.lemniscate.daycounter.data.models.RoomWidget
import com.github.endless.lemniscate.daycounter.data.models.converters.Converters

@Database(entities = [RoomWidget::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun widgetDao(): WidgetDao
}
