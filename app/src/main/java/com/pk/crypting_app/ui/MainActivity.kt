package com.pk.crypting_app.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pk.crypting_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var marketsAdapter: MarketAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()

        initViewModel()
    }

    /**
     * Initializes recycler view containing list of markets
     */
    private fun initRecyclerView() {
        marketsAdapter = MarketAdapter()
        binding.marketsRecView.setHasFixedSize(true)
        binding.marketsRecView.layoutManager = LinearLayoutManager(this)
        binding.marketsRecView.adapter = marketsAdapter
    }

    /**
     * Initializes view model and observes for market list change
     */
    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.observeMarkets().observe(this, {
            binding.progressCircle.visibility = View.INVISIBLE
            marketsAdapter.setMarkets(it)
        })

        viewModel.getMarkets()
    }

    companion object {
        private const val TAG: String = "MainActivity"
    }
}