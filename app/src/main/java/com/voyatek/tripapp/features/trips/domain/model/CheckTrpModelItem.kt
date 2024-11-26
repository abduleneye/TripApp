package com.voyatek.tripapp.features.trips.domain.model

data class CheckTrpModelItem(
    val tripDescription: String,
    val tripEndDate: String,
    val tripLocationCity: String,
    val tripName: String,
    val tripStartDate: String,
    val tripTravelStyle: String
)