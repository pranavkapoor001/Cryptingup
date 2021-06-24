package com.pk.crypting_app.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pk.crypting_app.network.Market
import com.pk.crypting_app.network.MarketApi
import com.pk.crypting_app.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel : ViewModel() {

    private val marketList = MutableLiveData<List<Market>>()
    private val marketApi = RetrofitService.getInstance().create(MarketApi::class.java)

    fun observeMarkets() = marketList

    /**
     * Runs network call on background thread to get list of markets from api
     */
    fun getMarkets() {
        viewModelScope.launch {
            val response = marketApi.getMarkets("10", "0")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful)
                    marketList.postValue(response.body()?.markets)
            }
        }

    }
}