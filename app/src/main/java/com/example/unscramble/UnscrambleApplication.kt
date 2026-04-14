package com.example.unscramble

import android.app.Application
import com.example.unscramble.ui.WordHistoryDatabase
import com.example.unscramble.ui.WordHistoryRepository

class UnscrambleApplication : Application() {
    val database by lazy { WordHistoryDatabase.getDatabase(this) }
    val repository by lazy { WordHistoryRepository(database.wordHistoryDao()) }
}
