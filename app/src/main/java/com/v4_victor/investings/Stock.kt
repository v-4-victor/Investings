package com.v4_victor.investings

data class Stock(
    val title: String,
    val fullTitle: String,
    val currentPrice: String,
    val openPrice: String,
    val image: String = ""
)