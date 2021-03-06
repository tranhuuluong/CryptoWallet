package com.luongtran.cryptowallet.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Created by LuongTran on 31/08/2021.
 */
@Database(
    entities = [
        CryptoEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cryptoDao(): CryptoDao

    companion object {
        fun buildDatabase(context: Context): AppDatabase {
            return Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}