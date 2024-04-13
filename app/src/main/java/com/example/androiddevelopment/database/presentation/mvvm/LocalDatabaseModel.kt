package com.example.androiddevelopment.database.presentation.mvvm

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.androiddevelopment.database.entities.Word

data class LocalDatabaseModel(
    val words: SnapshotStateList<Word> = mutableStateListOf(),
    var textFieldData : String = ""
)
