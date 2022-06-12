package ru.nlct.nationalkeyboard.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface KeyboardLanguageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLanguages(languages: List<KeyboardLanguageEntity>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateLanguage(entity: KeyboardLanguageEntity)

    @Query("SELECT * FROM ${KeyboardLanguageEntity.Schema.TABLE_NAME}")
    suspend fun getLanguages(): List<KeyboardLanguageEntity>

}
