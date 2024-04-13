package com.example.androiddevelopment.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "words_table")        // set name for column if you want, otherwise this will put the name of column automatically
data class Word(@PrimaryKey val id: Int? = null, @ColumnInfo(name = "text") val text: String)