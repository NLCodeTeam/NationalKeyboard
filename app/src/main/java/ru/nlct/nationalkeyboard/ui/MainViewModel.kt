package ru.nlct.nationalkeyboard.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _keyboardEnabledState = MutableSharedFlow<Boolean>(replay = 0)
    val keyboardEnabledState: SharedFlow<Boolean>
        get() = _keyboardEnabledState

    fun enableKeyboard() {
        viewModelScope.launch {
            _keyboardEnabledState.emit(true)
        }
    }

    data class MainContentViewState(
        val loading: Boolean = false,
       // val meals: List<DayMeal?> = emptyList(),
        val isEmpty: Boolean = true,
        val hasError: Boolean = false
    )
}