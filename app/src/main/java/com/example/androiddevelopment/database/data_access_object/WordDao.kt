package com.example.androiddevelopment.database.data_access_object

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androiddevelopment.database.entities.Word
import kotlinx.coroutines.flow.Flow


@Dao
interface WordDao {

    @Query("SELECT * FROM words_table ORDER BY id ASC")
    fun getAllWords(): Flow<List<Word>>; // Flow is Like Stream in Dart (kotlin's coroutins)


    @Insert
    suspend fun insertWord(word: Word);


    @Query("DELETE FROM words_table")
    fun deleteAll()

}