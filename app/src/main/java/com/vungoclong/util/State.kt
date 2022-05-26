package com.vungoclong.util

sealed class State {
    object None : State()
    object Loading : State()
    object Success : State()
    class Error(val errorMessage: String) : State()
}