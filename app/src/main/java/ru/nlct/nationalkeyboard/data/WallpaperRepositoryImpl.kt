package ru.nlct.nationalkeyboard.data

import android.content.SharedPreferences
import android.net.Uri
import ru.nlct.nationalkeyboard.R
import ru.nlct.nationalkeyboard.domain.model.WallpaperItem
import ru.nlct.nationalkeyboard.domain.repository.WallpaperRepository
import javax.inject.Inject

class WallpaperRepositoryImpl @Inject constructor(
    private val preferences: SharedPreferences
): WallpaperRepository {
    private val wallpapers = mutableListOf<WallpaperItem>()

    override fun loadWallpapers(): List<WallpaperItem> {
        val selectedId = getSelectedWallpaperIndex()
        if (wallpapers.isEmpty()) {
            initDefaultWallpapers(selectedId)
        } else {
            updateSelectedIndex(selectedId)
        }

        return wallpapers
    }

    override fun saveSelectedWallpaperIndex(id: Int?) {
        if (id == null) {
            preferences.edit().putInt(SAVED, NON_SELECTED).apply()
        } else {
            preferences.edit().putInt(SAVED, id).apply()
            if (wallpapers.isEmpty()) {
                initDefaultWallpapers(id)
            } else {
                updateSelectedIndex(id)
            }
        }
    }

    private fun updateSelectedIndex(selectedId: Int) {
        wallpapers.forEach {
            it.selected = it.id == selectedId
        }
    }

    private fun initDefaultWallpapers(selectedId: Int) {
        repeat(WALLPAPERS.size) {
            val key = WALLPAPERS.keys.elementAt(it)
            wallpapers.add(
                WallpaperItem(
                    id = it,
                    titleId = key,
                    uri = Uri.parse("${ASSETS_FOLDER}${WALLPAPERS[key]}"),
                    selected = selectedId == it
                )
            )
        }
    }

    private fun getSelectedWallpaperIndex(): Int = preferences.getInt(SAVED, NON_SELECTED)


    companion object {
        private const val SAVED = "wallpaper_saved"
        private const val ASSETS_FOLDER = "file:///android_asset/"
        private const val NON_SELECTED = -1
        private val WALLPAPERS = mapOf(
            R.string.adygei to "adygei.png",
            R.string.chechen to "chechen.png",
            R.string.dagestan to "dagestan.png",
            R.string.ingush to "ing.png",
            R.string.kbr to "kbr.png",
            R.string.kchr to "kchr.png",
            R.string.os to "os.png",
            R.string.ru to "ru.png",
            R.string.uk to "uk.png",
            R.string.usa to "usa.png"
        )
    }
}