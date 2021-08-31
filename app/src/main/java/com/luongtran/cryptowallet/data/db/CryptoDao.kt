package com.luongtran.cryptowallet.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * Created by LuongTran on 31/08/2021.
 */
@Dao
interface CryptoDao {
    @Query("SELECT * FROM ${CryptoEntity.TABLE_NAME}")
    fun getAll(): Flow<List<CryptoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<CryptoEntity>)

    @Query("DELETE FROM ${CryptoEntity.TABLE_NAME}")
    suspend fun deleteAll()

    @Transaction
    suspend fun deleteAllAndInsert(items: List<CryptoEntity>) {
        deleteAll()
        insert(items)
    }
}