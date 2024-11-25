package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components

import android.opengl.Visibility

data class PlanTripUiState(
    val tripLocationCity: String ="",
    val tripStartDate: String = "",
    val tripEndDate: String = "",
    val tripName: String = "",
    val tripTravelStyle: String = "",
    val tripDescription: String = "",
    val createTripDialogBoxVisibility: Boolean = false,
    val createTripLoadingDialogBoxVisibility: Boolean = false
)

