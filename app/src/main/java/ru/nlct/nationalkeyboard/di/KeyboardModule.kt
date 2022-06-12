package ru.nlct.nationalkeyboard.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import ru.nlct.nationalkeyboard.data.KeyboardLanguageRepositoryImpl
import ru.nlct.nationalkeyboard.data.NationalKeyboardLocalDataSource
import ru.nlct.nationalkeyboard.domain.repository.KeyboardLanguageRepository
import ru.nlct.nationalkeyboard.domain.usecase.GetLanguagesUseCase
import ru.nlct.nationalkeyboard.domain.usecase.UpdateLanguagesUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object KeyboardModule {

    @Provides
    @Singleton
    fun provideNationalKeyboardRepository(dataSource: NationalKeyboardLocalDataSource): KeyboardLanguageRepository =
        KeyboardLanguageRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideGetLanguageUseCase(
        repository: KeyboardLanguageRepository,
        @MainDispatcher dispatcher: CoroutineDispatcher
    ) = GetLanguagesUseCase(repository, dispatcher)

    @Provides
    @Singleton
    fun provideUpdateLanguageUseCase(
        repository: KeyboardLanguageRepository,
        @MainDispatcher dispatcher: CoroutineDispatcher
    ) = UpdateLanguagesUseCase(repository, dispatcher)
}