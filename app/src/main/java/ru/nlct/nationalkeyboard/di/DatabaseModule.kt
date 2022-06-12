package ru.nlct.nationalkeyboard.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import ru.nlct.nationalkeyboard.data.NationalKeyboardDataSource
import ru.nlct.nationalkeyboard.data.NationalKeyboardLocalDataSource
import ru.nlct.nationalkeyboard.data.database.Constants
import ru.nlct.nationalkeyboard.data.database.KeyboardLanguageDao
import ru.nlct.nationalkeyboard.data.database.KeyboardLanguageEntity
import ru.nlct.nationalkeyboard.data.database.NationalKeyboardDatabase
import ru.nlct.nationalkeyboard.domain.Mapper
import ru.nlct.nationalkeyboard.ui.model.KeyboardLanguage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideNationalKeyboardDatabase(@ApplicationContext context: Context): NationalKeyboardDatabase =
        Room.databaseBuilder(context, NationalKeyboardDatabase::class.java, Constants.DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideKeyboardLanguageDao(db: NationalKeyboardDatabase): KeyboardLanguageDao = db.languagesDao

    @Provides
    @Singleton
    fun provideNationalKeyboardDataSource(
        keyboardLanguageDao: KeyboardLanguageDao,
        mapper: Mapper<KeyboardLanguageEntity, KeyboardLanguage>,
        @IoDispatcher dispatcher: CoroutineDispatcher
    ): NationalKeyboardLocalDataSource = NationalKeyboardDataSource(keyboardLanguageDao, mapper, dispatcher)

    @Provides
    @Singleton
    fun provideLanguageMapper(): Mapper<KeyboardLanguageEntity, KeyboardLanguage> =
        object : Mapper<KeyboardLanguageEntity, KeyboardLanguage> {
            override fun toModel(entity: KeyboardLanguageEntity) = with(entity) {
                KeyboardLanguage(id, title, enabled)
            }

            override fun toEntity(model: KeyboardLanguage) = with(model) {
                KeyboardLanguageEntity(id, title, enabled)
            }
        }
}