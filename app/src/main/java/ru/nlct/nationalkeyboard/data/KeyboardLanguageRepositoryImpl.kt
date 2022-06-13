package ru.nlct.nationalkeyboard.data

import ru.nlct.nationalkeyboard.data.database.Constants
import ru.nlct.nationalkeyboard.domain.repository.KeyboardLanguageRepository
import ru.nlct.nationalkeyboard.domain.model.KeyboardLanguage
import javax.inject.Inject

class KeyboardLanguageRepositoryImpl @Inject constructor(
    private val dataSource: NationalKeyboardLocalDataSource
): KeyboardLanguageRepository {

    override suspend fun getLanguages(): List<KeyboardLanguage> {
        var saved = dataSource.getLanguages()
        if (saved.isEmpty()) {
            dataSource.saveLanguages(Constants.LANGUAGES)
            saved = dataSource.getLanguages()
        }
        return saved
    }

    override suspend fun updateLanguage(language: KeyboardLanguage) {
        dataSource.updateLanguage(language)
    }
}
