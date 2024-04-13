package com.example.androiddevelopment.database.presentation.mvvm

import android.content.Context
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevelopment.database.db.LocalDatabase
import com.example.androiddevelopment.database.entities.Word
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LocalDatabaseViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LocalDatabaseModel())
    val uiState: StateFlow<LocalDatabaseModel> = _uiState.asStateFlow()

    private var localDatabase: LocalDatabase? = null;

    fun initLocalDatabase(context: Context) {
        localDatabase = LocalDatabase.getDatabase(context = context)

        viewModelScope.launch {
            val flowObserver = localDatabase?.wordDao()?.getAllWords();
            flowObserver?.collect { flowWords ->
                _uiState.update { currentState -> currentState.copy(words = flowWords.toMutableStateList()) }
            }
        }
    }


    fun addWordFunc(value: String): Boolean {

        val newWord = Word(text = value)

        runBlocking {
            val func = async { localDatabase?.wordDao()?.insertWord(newWord) }
            func.await();
        }

        return true;
    }

}