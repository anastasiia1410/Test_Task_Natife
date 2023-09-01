package com.example.presentation.screens.gif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.presentation.core.BaseFragment
import com.example.presentation.databinding.FragmentGifBinding

class GifFragment : BaseFragment<FragmentGifBinding>() {
    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentGifBinding {
        return FragmentGifBinding.inflate(inflater, container, false)
    }
}