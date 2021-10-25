package com.github.endless.lemniscate.daycounter.data.models

import com.github.endless.lemniscate.daycounter.domain.models.Widget

fun RoomWidget.toWidget(): Widget {
    return Widget(
        id = this.id,
        title = this.title,
        date = this.date,
        shape = this.shape,
        color = this.color
    )
}

fun Widget.toRomWidget(): RoomWidget {
    return RoomWidget(
        id = this.id,
        title = this.title,
        date = this.date,
        shape = this.shape,
        color = this.color
    )
}