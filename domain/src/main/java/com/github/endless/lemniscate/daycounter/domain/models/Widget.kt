package com.github.endless.lemniscate.daycounter.domain.models

import java.util.*

data class Widget(
    val id: Int,
    var title: String,
    var date: Date,
    var shape: WidgetShape,
    var color: Int
)
