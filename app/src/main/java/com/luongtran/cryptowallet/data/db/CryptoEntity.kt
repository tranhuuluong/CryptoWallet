package com.luongtran.cryptowallet.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by LuongTran on 31/08/2021.
 */
@Entity(tableName = CryptoEntity.TABLE_NAME)
data class CryptoEntity(
    @ColumnInfo(name = COLUMN_ID)
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = COLUMN_BUY_PRICE)
    val buyPrice: Double?,
    @ColumnInfo(name = COLUMN_SELL_PRICE)
    val sellPrice: Double?,
    @ColumnInfo(name = COLUMN_ICON)
    val icon: String?,
    @ColumnInfo(name = COLUMN_NAME)
    val name: String?
) {
    companion object {
        const val TABLE_NAME = "crypto"
        const val COLUMN_ID = "id"
        const val COLUMN_BUY_PRICE = "buy_price"
        const val COLUMN_SELL_PRICE = "sell_price"
        const val COLUMN_ICON = "icon"
        const val COLUMN_NAME = "name"
    }
}