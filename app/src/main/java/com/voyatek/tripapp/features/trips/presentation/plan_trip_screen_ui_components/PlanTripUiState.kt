package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components

import android.opengl.Visibility
import com.voyatek.tripapp.features.trips.domain.model.GetTripModel

data class PlanTripUiState(
    val plannedTrips: List<GetTripModel> = emptyList(),
    val tripLocationCity: String ="",
    val tripStartDate: String = "",
    val tripEndDate: String = "",
    val tripName: String = "",
    val tripTravelStyle: String = "",
    val tripDescription: String = "",
    val createTripDialogBoxVisibility: Boolean = false,
    val createTripLoadingDialogBoxVisibility: Boolean = false,
    val tripCreatedSuccessfully: Boolean = false,
    val tripCreationFailed: Boolean = false,
    val tripCreationInProgress: Boolean = false,
    val bottomSheetVisibility: Boolean = false,
    val tripIsLoading: Boolean = false,
    val tripLoadingStatus: String = "",


    )

