package com.example.unscramble.ui

import kotlinx.coroutines.flow.Flow

class WordHistoryRepository(private val wordHistoryDao: com.example.unscramble.WordHistoryDao) {
    
    val allHistory: Flow<List<WordHistory>> = wordHistoryDao.getAllHistory()

    suspend fun insertWord(word: String) {
        val historyEntry = WordHistory(word = word)
        wordHistoryDao.insert(historyEntry)
    }
}
