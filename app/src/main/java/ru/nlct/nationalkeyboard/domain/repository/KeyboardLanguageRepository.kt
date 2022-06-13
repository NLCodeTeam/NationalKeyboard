package ru.nlct.nationalkeyboard.domain.repository

import ru.nlct.nationalkeyboard.domain.model.KeyboardLanguage

interface KeyboardLanguageRepository {
    suspend fun getLanguages(): List<KeyboardLanguage>
    suspend fun updateLanguage(language: KeyboardLanguage)
}
