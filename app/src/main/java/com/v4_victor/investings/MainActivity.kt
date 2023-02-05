package com.v4_victor.investings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.v4_victor.investings.databinding.ActivityMainBinding
import com.v4_victor.investings.stockings_list.StockingsAdapter
import com.v4_victor.websocket.Websocket


class MainActivity : AppCompatActivity() {
    val list = listOf(
        Stock("AAPL","APPLE", "100", "121"),
        Stock("TSLA","TESLA", "100", "121"),
        Stock("GOOGL","GOOGLE", "100", "121"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val recycler = binding.recycler
        val adapter = StockingsAdapter(StockingsAdapter.OnClickListener{})
        recycler.adapter = adapter
        adapter.submitList(list)
    }
}