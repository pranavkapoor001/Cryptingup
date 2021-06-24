package com.pk.crypting_app.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pk.crypting_app.databinding.MarketItemBinding
import com.pk.crypting_app.network.Market

/**
 * Recycler view class to display list of markets
 */
class MarketAdapter : RecyclerView.Adapter<MarketAdapter.MarketViewHolder>() {

    private lateinit var binding: MarketItemBinding
    var marketList = mutableListOf<Market>()

    fun setMarkets(markets: List<Market>) {
        marketList = markets.toMutableList()
        notifyDataSetChanged()
    }

    class MarketViewHolder(private val binding: MarketItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currentMarket: Market) {
            binding.marketName.text = currentMarket.exchangeId
            binding.priceUSD.text = currentMarket.price.toString()
            binding.priceUnconverted.text = currentMarket.priceUnconverted.toString()
            binding.change24h.text = currentMarket.change24h.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        binding = MarketItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        val currentMarket: Market = marketList[position]
        return holder.bind(currentMarket)
    }

    override fun getItemCount(): Int {
        return marketList.size
    }
}