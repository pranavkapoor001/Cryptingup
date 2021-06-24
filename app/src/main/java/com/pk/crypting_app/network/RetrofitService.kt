package com.pk.crypting_app.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Class to build and return retrofit instance
 */
class RetrofitService {

    companion object {
        private const val BASE_URL = "https://www.cryptingup.com/api/"
        private var instance: Retrofit? = null

        fun getInstance(): Retrofit {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance as Retrofit
        }
    }
}