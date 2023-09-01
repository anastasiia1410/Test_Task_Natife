package com.example.presentation.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Gif
import com.example.domain.repository.GifsRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class GifsViewModel(private val gifsRepository: GifsRepository) : ViewModel() {
    private val _gifsFlow = MutableSharedFlow<List<Gif>>()
    val gifsFlow : SharedFlow<List<Gif>> = _gifsFlow
    private val _errorFlow = MutableSharedFlow<String>()
    val errorFlow: SharedFlow<String> = _errorFlow

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val errorMessage = when (throwable) {
            is UnknownHostException -> "No internet connection"
            is SocketTimeoutException -> "Server is not responding"
            else -> "Sorry, something went wrong"
        }
        _errorFlow.tryEmit(errorMessage)
    }

    fun load() = viewModelScope.launch(coroutineExceptionHandler + Dispatchers.IO) {
        val data = gifsRepository.getGifs()
        _gifsFlow.emit(data.gifsList)
    }
}