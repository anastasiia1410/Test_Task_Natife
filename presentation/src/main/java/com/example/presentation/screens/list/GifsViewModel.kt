package com.example.presentation.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Gif
import com.example.domain.repository.GifsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class GifsViewModel(private val gifsRepository: GifsRepository) : ViewModel() {
    val gifsFlow = MutableSharedFlow<List<Gif>>()

    fun load() = viewModelScope.launch(Dispatchers.IO) {
        val data = gifsRepository.getGifs()
        gifsFlow.emit(data.gifsList)
    }
}