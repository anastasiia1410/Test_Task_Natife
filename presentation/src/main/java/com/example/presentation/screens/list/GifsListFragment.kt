package com.example.presentation.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.presentation.core.BaseFragment
import com.example.presentation.databinding.FragmentListGifsBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GifsListFragment : BaseFragment<FragmentListGifsBinding>() {
    private val viewModel by viewModel<GifsViewModel>()
    private val gifsAdapter by lazy {
        GifsAdapter()
    }

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): FragmentListGifsBinding {
        return FragmentListGifsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.rvRecycler) {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = gifsAdapter
        }

        lifecycleScope.launch {
            viewModel.gifsFlow.collect {
                gifsAdapter.updateItems(it)
            }
        }
        viewModel.load()

    }
}