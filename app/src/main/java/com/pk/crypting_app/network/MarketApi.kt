package com.pk.crypting_app.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarketApi {
    @GET("markets")
    suspend fun getMarkets(
        @Query("size") size: String,
        @Query("start") start: String
    ): Response<MarketResponse>
}