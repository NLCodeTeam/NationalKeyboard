package ru.nlct.nationalkeyboard.domain.model

import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class WallpaperItem(
    val id: Int = -1,
    @StringRes val titleId: Int = -1,
    val uri: Uri = Uri.EMPTY,
    var selected: Boolean = false
)
