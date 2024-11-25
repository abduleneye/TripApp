package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voyatek.tripapp.features.trips.core.utils.Resource
import com.voyatek.tripapp.features.trips.domain.repo.TripApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanTripViewModel @Inject constructor(
    private val tripApiRepo: TripApiRepo
): ViewModel() {
    init {
        getTrips()
    }

    private var _tripScreenUiState = MutableStateFlow(PlanTripUiState())
    var tripScreenUiState = _tripScreenUiState.asStateFlow()

    private fun getTrips() {
        viewModelScope.launch {
            tripApiRepo.viewTrip().onEach { result ->
                when(result){
                    is Resource.Error -> {
                        Log.d(
                            "Trips",
                            "${result.message}"
                        )

                    }
                    is Resource.Loading -> {
                        Log.d(
                            "Trips",
                            "Trips Loading..."
                        )
                        Log.d(
                            "Trips",
                            "${result.message}"
                        )

                    }
                    is Resource.Success -> {
                        _tripScreenUiState.update {
                            it.copy(
                                tripName = result.data!!.tripName,
                                tripDescription = result.data.tripDescription,
                                travelStyle = result.data.travelStyle
                            )


                        }

                        Log.d(
                            "Trips",
                            "${result.data}"
                        )

                    }
                }


            }.launchIn(this)
        }
    }

}