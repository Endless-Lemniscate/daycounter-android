package com.github.endless.lemniscate.daycounter.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.endless.lemniscate.daycounter.domain.models.WidgetShape
import java.util.*

@Entity(tableName = "widget")
data class RoomWidget(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    var title: String,
    var date: Date,
    var shape: WidgetShape,
    var color: Int
)
