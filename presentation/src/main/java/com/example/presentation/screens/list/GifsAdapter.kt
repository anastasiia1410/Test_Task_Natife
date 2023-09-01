package com.example.presentation.screens.list

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.domain.entity.Gif
import com.example.presentation.databinding.ItemGifBinding

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
            pbProgressBar.visibility = View.VISIBLE
            Glide.with(ivImage.context)
                .load(item.image.fixedHeightSmallUrl.url)
                .fitCenter()
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean,
                    ): Boolean {
                        pbProgressBar.visibility = View.GONE
                        return false
                    }
                })
                .into(ivImage)
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