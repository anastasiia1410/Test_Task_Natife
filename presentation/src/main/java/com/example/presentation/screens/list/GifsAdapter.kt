package com.example.presentation.screens.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Gif
import com.example.presentation.databinding.ItemGifBinding
import com.example.presentation.utils.loadImage

class GifsAdapter : RecyclerView.Adapter<GifsAdapter.VH>() {
    private var items: MutableList<Gif> = mutableListOf()
    var onGifClick: ((url: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemGifBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        with(holder.binding)
        {
            ivImage.loadImage(item.image.fixedHeightSmallUrl.url)
            ivImage.setOnClickListener { onGifClick?.invoke(item.image.originalUrl.url) }
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(newItems: List<Gif>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class VH(val binding: ItemGifBinding) : RecyclerView.ViewHolder(binding.root)
}