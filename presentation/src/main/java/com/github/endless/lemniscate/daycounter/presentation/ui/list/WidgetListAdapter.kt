package com.github.endless.lemniscate.daycounter.presentation.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.endless.lemniscate.daycounter.databinding.WidgetListItemBinding
import com.github.endless.lemniscate.daycounter.domain.models.Widget

class WidgetListAdapter: RecyclerView.Adapter<WidgetListAdapter.ViewHolder>() {

    private val widgets = ArrayList<Widget>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WidgetListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = widgets.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(widgets[position])
    }

    fun setData(newWidgets: List<Widget>) {
        val diffCallback = WidgetsDiffCallback(widgets, newWidgets)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        widgets.clear()
        widgets.addAll(newWidgets)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(private val binding: WidgetListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(widget: Widget) {
            binding.title.text = widget.title
            binding.date.text = widget.date.toString()
            binding.time.text = widget.date.toString()
        }
    }

}