package com.example.baseapplication.di

import android.content.Context
import com.example.baseapplication.database.DbDao
import com.example.baseapplication.database.RoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): RoomDataBase {
        return RoomDataBase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideWallpaperDao(roomDB: RoomDataBase): DbDao {
        return roomDB.itemDB()
    }
}