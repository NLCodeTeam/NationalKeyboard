package ru.nlct.nationalkeyboard.domain.usecase

import kotlinx.coroutines.CoroutineDispatcher
import ru.nlct.nationalkeyboard.domain.base.SuspendUseCase
import ru.nlct.nationalkeyboard.domain.repository.KeyboardLanguageRepository
import ru.nlct.nationalkeyboard.domain.model.KeyboardLanguage
import javax.inject.Inject

class GetLanguagesUseCase @Inject constructor(
    private val repository: KeyboardLanguageRepository,
    dispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, List<KeyboardLanguage>>(dispatcher) {

    override suspend fun execute(arg: Unit): List<KeyboardLanguage> = repository.getLanguages()
}