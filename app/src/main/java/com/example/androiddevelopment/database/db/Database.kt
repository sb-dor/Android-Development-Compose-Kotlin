package com.example.androiddevelopment.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androiddevelopment.database.data_access_object.WordDao
import com.example.androiddevelopment.database.entities.Word


@Database(entities = [Word::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {


    abstract fun wordDao(): WordDao


    companion object {

        private var INSTANCE: LocalDatabase? = null

        fun getDatabase(context: Context): LocalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance: LocalDatabase =
                    Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        name = "name_of_the_local_database"
                    )
                        .build()
                INSTANCE = instance

                // return instance
                instance
            }
        }
    }

}