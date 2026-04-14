package com.example.unscramble.ui

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.unscramble.WordHistoryDao

@Database(entities = [WordHistory::class], version = 1, exportSchema = false)
abstract class WordHistoryDatabase : RoomDatabase() {
    
    abstract fun wordHistoryDao(): WordHistoryDao

    companion object {
        @Volatile
        private var Instance: WordHistoryDatabase? = null

        fun getDatabase(context: Context): WordHistoryDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    WordHistoryDatabase::class.java,
                    "word_history_database"
                )
                .build().also { Instance = it }
            }
        }
    }
}