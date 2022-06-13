package ru.nlct.nationalkeyboard.domain.usecase

import ru.nlct.nationalkeyboard.domain.base.UseCase
import ru.nlct.nationalkeyboard.domain.model.WallpaperItem
import ru.nlct.nationalkeyboard.domain.repository.WallpaperRepository
import javax.inject.Inject

class GetWallpapersUseCase @Inject constructor(
    private val repository: WallpaperRepository
): UseCase<Unit, List<WallpaperItem>>() {
    override fun execute(arg: Unit): List<WallpaperItem>  = repository.loadWallpapers()
}