package ru.nlct.nationalkeyboard.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import ru.nlct.nationalkeyboard.domain.base.SuspendUseCase
import ru.nlct.nationalkeyboard.domain.repository.KeyboardLanguageRepository
import ru.nlct.nationalkeyboard.ui.model.KeyboardLanguage
import javax.inject.Inject

class UpdateLanguagesUseCase @Inject constructor(
    private val repository: KeyboardLanguageRepository,
    dispatcher: CoroutineDispatcher
) : SuspendUseCase<KeyboardLanguage, Unit>(dispatcher) {

    override suspend fun execute(arg: KeyboardLanguage) = repository.updateLanguage(arg)
}