package com.example.model

sealed class LoadWordsState {
    data class Success(var words: List<WordEntity>) : LoadWordsState()
    data class Error(var error: Throwable) : LoadWordsState()
    object Loading : LoadWordsState()
}
