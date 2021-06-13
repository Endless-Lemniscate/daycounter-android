package com.github.endless.lemniscate.daycounter.presentation.models

import android.os.Parcelable
import com.github.endless.lemniscate.daycounter.domain.models.Widget
import com.github.endless.lemniscate.daycounter.domain.models.WidgetShape
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class WidgetParcelable(
    val id: Int,
    var title: String,
    var date: Date,
    var shape: WidgetShape,
    var color: Int
): Parcelable

fun Widget.toParcelable() = WidgetParcelable(id, title, date, shape, color)
