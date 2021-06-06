package com.github.endless.lemniscate.daycounter.presentation.ui.list

import androidx.recyclerview.widget.DiffUtil
import com.github.endless.lemniscate.daycounter.domain.models.Widget

class WidgetsDiffCallback(private val oldList: List<Widget>,
                          private val newList: List<Widget>): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size
    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        return oldItem.title == newItem.title &&
                oldItem.date == newItem.date &&
                oldItem.color == newItem.color &&
                oldItem.shape == newItem.shape
    }
}