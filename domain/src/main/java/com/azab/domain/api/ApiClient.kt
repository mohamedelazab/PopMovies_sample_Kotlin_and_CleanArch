package com.azab.domain.api

import com.azab.domain.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val BASE_URL = BuildConfig.BASE_URL
    private var retrofit: Retrofit? = null


    val client: Retrofit
        @Synchronized
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }

    fun getApi(): Api {
        return client.create(Api::class.java)
    }

}