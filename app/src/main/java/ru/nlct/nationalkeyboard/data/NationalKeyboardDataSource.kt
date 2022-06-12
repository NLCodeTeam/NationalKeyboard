package ru.nlct.nationalkeyboard.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.nlct.nationalkeyboard.data.database.KeyboardLanguageDao
import ru.nlct.nationalkeyboard.data.database.KeyboardLanguageEntity
import ru.nlct.nationalkeyboard.domain.Mapper
import ru.nlct.nationalkeyboard.ui.model.KeyboardLanguage
import javax.inject.Inject

class NationalKeyboardDataSource @Inject constructor(
    private val keyboardLanguageDao: KeyboardLanguageDao,
    private val mapper: Mapper<KeyboardLanguageEntity, KeyboardLanguage>,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): NationalKeyboardLocalDataSource {

    override suspend fun getLanguages(): List<KeyboardLanguage> = withContext(ioDispatcher) {
        keyboardLanguageDao.getLanguages().map { mapper.toModel(it) }
    }

    override suspend fun saveLanguages(languages: List<KeyboardLanguage>) = withContext(ioDispatcher) {
        keyboardLanguageDao.saveLanguages(languages.map { mapper.toEntity(it) })
    }

    override suspend fun updateLanguage(language: KeyboardLanguage) = withContext(ioDispatcher) {
        keyboardLanguageDao.updateLanguage(mapper.toEntity(language))
    }
}