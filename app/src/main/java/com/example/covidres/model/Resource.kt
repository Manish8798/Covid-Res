package com.example.covidres.model

data class Resource(
    val updated: Long,
    val cases: Int,
    val todayCases: Int,
    val deaths: Int,
    val todayDeaths: Int,
    val recovered: Int,
    val active: Int,
    val critical: Int,
    val continent: String
)
