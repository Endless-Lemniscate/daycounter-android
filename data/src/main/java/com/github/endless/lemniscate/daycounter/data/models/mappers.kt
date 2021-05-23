package com.github.endless.lemniscate.daycounter.data.models

import com.github.endless.lemniscate.daycounter.domain.models.Widget

internal val RoomWidget.toDomain: Widget
    get() {
        return Widget(
            id = this.id,
            title = this.title,
            date = this.date,
            shape = this.shape,
            color = this.color
        )
    }

internal val Widget.toData: RoomWidget
    get() {
        return RoomWidget(
            id = this.id,
            title = this.title,
            date = this.date,
            shape = this.shape,
            color = this.color
        )
    }