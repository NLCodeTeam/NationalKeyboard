package ru.nlct.nationalkeyboard.data

import ru.nlct.nationalkeyboard.domain.model.KeyboardLanguage

interface NationalKeyboardLocalDataSource{
    suspend fun getLanguages(): List<KeyboardLanguage>
    suspend fun saveLanguages(languages: List<KeyboardLanguage>)
    suspend fun updateLanguage(language: KeyboardLanguage)
}