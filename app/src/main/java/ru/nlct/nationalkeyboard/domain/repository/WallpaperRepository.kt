package ru.nlct.nationalkeyboard.domain.repository

import ru.nlct.nationalkeyboard.domain.model.WallpaperItem

interface WallpaperRepository {
    fun loadWallpapers(): List<WallpaperItem>
    fun saveSelectedWallpaperIndex(id: Int?)
}