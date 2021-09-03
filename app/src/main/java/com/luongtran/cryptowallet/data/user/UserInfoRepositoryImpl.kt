package com.luongtran.cryptowallet.data.user

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.luongtran.cryptowallet.domain.user.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

/**
 * Created by LuongTran on 03/09/2021.
 */
class UserInfoRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : UserInfoRepository {

    private object PrefKeys {
        val KEY_FAVORITES = stringSetPreferencesKey("favorites")
    }

    override suspend fun fetchFavorites() {
        //fetch favorites from server
        val response = listOf("BTC", "BCH")

        saveFavorites(response)
    }

    override suspend fun getFavorites(): Flow<Set<String>> {
        return dataStore.data
            .map { prefs -> prefs[PrefKeys.KEY_FAVORITES] ?: emptySet() }
            .distinctUntilChanged()
    }

    private suspend fun saveFavorites(data: List<String>) {
        dataStore.edit { prefs ->
            prefs[PrefKeys.KEY_FAVORITES] = data.toSet()
        }
    }

    override suspend fun updateFavorite(id: String, isFavorite: Boolean) {
        dataStore.edit { prefs ->
            val current = prefs[PrefKeys.KEY_FAVORITES] ?: emptySet()
            if (isFavorite) {
                prefs[PrefKeys.KEY_FAVORITES] = current.plus(id)
            } else {
                prefs[PrefKeys.KEY_FAVORITES] = current.minus(id)
            }
        }
    }
}