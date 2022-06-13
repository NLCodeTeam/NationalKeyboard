package ru.nlct.nationalkeyboard.domain.usecase

import ru.nlct.nationalkeyboard.domain.base.UseCase
import ru.nlct.nationalkeyboard.domain.model.WallpaperItem
import ru.nlct.nationalkeyboard.domain.repository.WallpaperRepository
import javax.inject.Inject

class SavedWallpaperUseCase @Inject constructor(
    private val repository: WallpaperRepository
): UseCase<WallpaperItem?, Unit>() {
    override fun execute(arg: WallpaperItem?) {
        repository.saveSelectedWallpaperIndex(arg?.id)
    }
}