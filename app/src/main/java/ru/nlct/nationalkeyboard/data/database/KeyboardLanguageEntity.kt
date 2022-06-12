package ru.nlct.nationalkeyboard.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = KeyboardLanguageEntity.Schema.TABLE_NAME,
    primaryKeys = [KeyboardLanguageEntity.Schema.LANGUAGE_ID]
)
data class KeyboardLanguageEntity(
    @ColumnInfo(name = Schema.LANGUAGE_ID) val id: Int,
    @ColumnInfo(name = Schema.LANGUAGE_TITLE) val title: String,
    @ColumnInfo(name = Schema.LANGUAGE_ENABLE) val enabled: Boolean
) {
    object Schema {
        const val TABLE_NAME = "languages"
        const val LANGUAGE_ID = "id"
        const val LANGUAGE_TITLE = "title"
        const val LANGUAGE_ENABLE = "enable"
    }
}