package com.github.endless.lemniscate.daycounter.data.models.converters

import androidx.room.TypeConverter
import com.github.endless.lemniscate.daycounter.domain.models.WidgetShape
import java.util.*

class Converters {

    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toWidgetShape(ordinal: Int): WidgetShape {
        return WidgetShape.values()[ordinal]
    }

    @TypeConverter
    fun toInt(widgetShape: WidgetShape): Int {
        return widgetShape.ordinal
    }
}