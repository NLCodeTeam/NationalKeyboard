package ru.nlct.nationalkeyboard.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [KeyboardLanguageEntity::class], version = Constants.VERSION)
abstract class NationalKeyboardDatabase : RoomDatabase() {
    abstract val languagesDao: KeyboardLanguageDao
}