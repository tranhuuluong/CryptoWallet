package com.luongtran.cryptowallet.data.content

import com.luongtran.cryptowallet.data.db.CryptoDao
import com.luongtran.cryptowallet.data.network.CryptoService
import com.luongtran.cryptowallet.domain.content.CryptoRepository
import com.luongtran.cryptowallet.domain.mapper.toCrypto
import com.luongtran.cryptowallet.domain.mapper.toCryptoEntity
import com.luongtran.cryptowallet.domain.model.Crypto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by LuongTran on 31/08/2021.
 */
class CryptoRepositoryImpl(
    private val cryptoService: CryptoService,
    private val cryptoDao: CryptoDao,
) : CryptoRepository {

    override suspend fun fetchPrices(counter: String) {
        val response = cryptoService.getAllPrices(counter).data ?: emptyList()
        cryptoDao.deleteAllAndInsert(response.map { it.toCryptoEntity() })
    }

    override fun getPrices(): Flow<List<Crypto>> {
        return cryptoDao.getAll().map { entities ->
            entities.map { it.toCrypto() }
        }
    }

    override fun search(keyword: String): Flow<List<Crypto>> {
        return if (keyword.isEmpty()) {
            cryptoDao.getAll()
        } else {
            cryptoDao.search(keyword.toDbQuery())
        }.map { list ->
            list.map { it.toCrypto() }
        }
    }

    private fun String.toDbQuery() = "%$this%"
}