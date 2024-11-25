package com.voyatek.tripapp.features.trips.domain.model

data class CreateTripBodyModel(
    val tripLocationCity: String,
    val tripStartDate: String,
    val tripEndDate: String,
    val tripName: String,
    val tripTravelStyle: String,
    val tripDescription: String,
)
