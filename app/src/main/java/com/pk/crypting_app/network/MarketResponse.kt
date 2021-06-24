package com.pk.crypting_app.network

import com.google.gson.annotations.SerializedName

data class MarketResponse(
    val markets: List<Market>
)

data class Market(
    @SerializedName("exchange_id")
    var exchangeId: String? = null,
    var symbol: String? = null,
    @SerializedName("price_unconverted")
    var priceUnconverted: Double = 0.0,
    var price: Double = 0.0,
    @SerializedName("change_24h")
    var change24h: Double = 0.0,
    var spread: Double = 0.0,
    @SerializedName("volume_24h")
    var volume24h: Double = 0.0,
    var status: String? = null,
    //  var time: Date? = null
)