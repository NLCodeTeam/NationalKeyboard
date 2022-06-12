package ru.nlct.nationalkeyboard.domain.repository

import ru.nlct.nationalkeyboard.ui.model.KeyboardLanguage

interface KeyboardLanguageRepository {
    suspend fun getLanguages(): List<KeyboardLanguage>
    suspend fun updateLanguage(language: KeyboardLanguage)
}
