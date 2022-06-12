package ru.nlct.nationalkeyboard.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.nlct.nationalkeyboard.domain.base.data
import ru.nlct.nationalkeyboard.domain.usecase.GetLanguagesUseCase
import ru.nlct.nationalkeyboard.domain.usecase.UpdateLanguagesUseCase
import ru.nlct.nationalkeyboard.ui.model.DictionaryItem
import ru.nlct.nationalkeyboard.ui.model.KeyboardLanguage
import ru.nlct.nationalkeyboard.ui.model.ScreenNavigation
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getLanguagesUseCase: GetLanguagesUseCase,
    private val updateLanguagesUseCase: UpdateLanguagesUseCase
) : ViewModel() {

    private val _changeScreenState = MutableSharedFlow<ScreenNavigation>(replay = 0)
    val changeScreenState: SharedFlow<ScreenNavigation>
        get() = _changeScreenState

    private val languageStateMutable = MutableStateFlow<List<KeyboardLanguage>>(listOf())
    val languageState: StateFlow<List<KeyboardLanguage>>
        get() = languageStateMutable

    private val dictsStateMutable = MutableStateFlow<List<DictionaryItem>>(listOf())
    val dictsState: StateFlow<List<DictionaryItem>>
        get() = dictsStateMutable

    fun loadLanguages() {
        viewModelScope.launch {
            loadAllLanguages()
        }
    }

    private suspend fun loadAllLanguages() {
        val result = getLanguagesUseCase(Unit)
        result.data?.let {
            languageStateMutable.emit(it)
        }
    }

    fun changeChooseLanguage(language: KeyboardLanguage, enabled: Boolean) {
        viewModelScope.launch {
            val changedLanguage = KeyboardLanguage(language.id, language.title, enabled)
            val result = updateLanguagesUseCase(changedLanguage)
            if (result.data != null) {
                loadAllLanguages()
            }
        }
    }

    fun enableKeyboard() = openScreen(ScreenNavigation.EnableKeyboard)

    fun openLanguagesScreen() = openScreen(ScreenNavigation.Language)

    fun selectKeyboard() = openScreen(ScreenNavigation.SelectKeyboard)

    fun openDictsScreen() = openScreen(ScreenNavigation.Dictionary)

    fun openWallpapersScreen() = openScreen(ScreenNavigation.Wallpaper)

    private fun openScreen(screen: ScreenNavigation) {
        viewModelScope.launch {
            _changeScreenState.emit(screen)
        }
    }
}