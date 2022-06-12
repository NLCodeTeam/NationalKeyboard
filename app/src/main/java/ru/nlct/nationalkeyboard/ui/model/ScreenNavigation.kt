package ru.nlct.nationalkeyboard.ui.model

import androidx.annotation.StringRes
import ru.nlct.nationalkeyboard.R

sealed class ScreenNavigation(@StringRes val resId: Int) {
    object Main: ScreenNavigation(R.string.app_name)
    object Language: ScreenNavigation(R.string.select_lang_keyboard_title)
    object Wallpaper: ScreenNavigation(R.string.wallpapers_keyboard_title)
    object Dictionary: ScreenNavigation(R.string.dictionary_keyboard_title)
    object EnableKeyboard: ScreenNavigation(R.string.enable_keyboard_title)
    object SelectKeyboard: ScreenNavigation(R.string.select_keyboard_title)
}
