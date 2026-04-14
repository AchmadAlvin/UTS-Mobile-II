package com.example.unscramble

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.unscramble.ui.WordHistory
import kotlinx.coroutines.flow.Flow

@Dao
interface WordHistoryDao {
    @Insert
    suspend fun insert(wordHistory: WordHistory)

    @Query("SELECT * FROM word_history ORDER BY timestamp DESC")
    fun getAllHistory(): Flow<List<WordHistory>>
}
