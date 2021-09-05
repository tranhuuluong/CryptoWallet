package com.luongtran.cryptowallet.di

import com.luongtran.cryptowallet.data.network.CryptoService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by LuongTran on 31/08/2021.
 */
val networkModule = module {
    single { createOkHttpClient() }

    single { createWebService<CryptoService>(get(), getProperty(Properties.SERVER_URL)) }
}

private fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}

object Properties {
    const val SERVER_URL = "SERVER_URL"
}
