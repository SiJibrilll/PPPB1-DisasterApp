package com.example.hambalangdisasterapp.model

data class Disaster (
    val nameDisaster: String = "",
    val disasterType: String = "",
    val iconResId: Int // new property for the drawable resource
)