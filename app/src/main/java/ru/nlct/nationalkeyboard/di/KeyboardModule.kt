package ru.nlct.nationalkeyboard.di

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import ru.nlct.nationalkeyboard.data.KeyboardLanguageRepositoryImpl
import ru.nlct.nationalkeyboard.data.NationalKeyboardLocalDataSource
import ru.nlct.nationalkeyboard.data.WallpaperRepositoryImpl
import ru.nlct.nationalkeyboard.domain.repository.KeyboardLanguageRepository
import ru.nlct.nationalkeyboard.domain.repository.WallpaperRepository
import ru.nlct.nationalkeyboard.domain.usecase.GetLanguagesUseCase
import ru.nlct.nationalkeyboard.domain.usecase.GetWallpapersUseCase
import ru.nlct.nationalkeyboard.domain.usecase.SavedWallpaperUseCase
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
    fun provideWallpapersRepository(preferences: SharedPreferences): WallpaperRepository =
        WallpaperRepositoryImpl(preferences)

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

    @Provides
    @Singleton
    fun provideGetWallpapersUseCase(repository: WallpaperRepository) =
        GetWallpapersUseCase(repository)

    @Provides
    @Singleton
    fun provideSavedWallpaperUseCase(repository: WallpaperRepository) =
        SavedWallpaperUseCase(repository)
}