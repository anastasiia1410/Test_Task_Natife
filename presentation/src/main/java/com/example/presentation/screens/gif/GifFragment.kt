package com.example.presentation.screens.gif

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.presentation.core.BaseFragment
import com.example.presentation.databinding.FragmentGifBinding

class GifFragment : BaseFragment<FragmentGifBinding>() {
    private val gifArgs by navArgs<GifFragmentArgs>()
    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentGifBinding {
        return FragmentGifBinding.inflate(inflater, container, false).also { binding ->
            addWindowInsets(binding.root)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = gifArgs.url
        binding.pbProgressBar.visibility = View.VISIBLE
        Glide.with(this)
            .load(url)
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
                    binding.pbProgressBar.visibility = View.GONE
                    return false
                }
            })
            .into(binding.ivImage)
    }
}