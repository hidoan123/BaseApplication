package com.example.baseapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(
//    entities = [Item::class],
//)
abstract class RoomDataBase : RoomDatabase() {
    companion object {
        @Volatile
        private var instance: RoomDataBase? = null
        fun getInstance(context: Context): RoomDataBase {
            return instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context): RoomDataBase {
            return Room.databaseBuilder(
                context,
                RoomDataBase::class.java,
                "DataBaseItem"
            ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
        }
    }

    abstract fun itemDB(): DbDao
}