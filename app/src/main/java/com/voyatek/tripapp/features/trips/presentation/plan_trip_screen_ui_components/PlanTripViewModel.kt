package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voyatek.tripapp.features.trips.core.utils.Resource
import com.voyatek.tripapp.features.trips.domain.model.CreateTripBodyModel
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
                                tripTravelStyle = result.data.travelStyle
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

    private fun createTrips(){
        viewModelScope.launch {

            tripApiRepo.createTrip(
                CreateTripBodyModel(
                    tripLocationCity = _tripScreenUiState.value.tripLocationCity,
                    tripStartDate = _tripScreenUiState.value.tripStartDate,
                    tripEndDate = _tripScreenUiState.value.tripEndDate,
                    tripName = _tripScreenUiState.value.tripName,
                    tripTravelStyle = _tripScreenUiState.value.tripTravelStyle,
                    tripDescription = _tripScreenUiState.value.tripDescription
                )
            ).onEach { result ->
                when(result){
                    is Resource.Error -> {
                        Log.d(
                            "CREATE_TRIP",
                            "${result.message}"
                        )

                    }
                    is Resource.Loading -> {

                        _tripScreenUiState.update {
                            it.copy(
                                createTripLoadingDialogBoxVisibility = true
                            )
                        }

                    }
                    is Resource.Success -> {
                        Log.d(
                            "CREATE_TRIP",
                            "${result.data}"
                        )
                        _tripScreenUiState.update {
                            it.copy(
                                createTripLoadingDialogBoxVisibility = false
                            )
                        }

                    }
                }
            }.launchIn(this)

        }
    }



    fun onEvent(event: UiEventClass){
        when(event){
            is UiEventClass.setTripEndDate -> {
                _tripScreenUiState.update {
                    it.copy(
                        tripEndDate = event.tripEndDate
                    )
                }

            }
            is UiEventClass.setTripLocation -> {
                _tripScreenUiState.update {
                    it.copy(
                        tripLocationCity = event.tripLocation
                    )
                }

            }
            is UiEventClass.setTripStartDate -> {
                _tripScreenUiState.update {
                    it.copy(
                        tripStartDate = event.tripStartDate
                    )
                }

            }

            is UiEventClass.setTripDescription -> {
                _tripScreenUiState.update {
                    it.copy(
                        tripDescription = event.tripDescription
                    )
                }

            }
            is UiEventClass.setTripName -> {
                _tripScreenUiState.update {
                    it.copy(
                        tripName = event.tripName
                    )
                }

            }
            is UiEventClass.setTripTravelStyle -> {
                _tripScreenUiState.update {
                    it.copy(
                        tripTravelStyle = event.tripTravelStyle
                    )
                }

            }

            UiEventClass.hideCreateTripDialogBoxVisibility -> {
                _tripScreenUiState.update {
                    it.copy(
                        createTripDialogBoxVisibility = false
                    )
                }

            }
            UiEventClass.showCreateTripDialogBox -> {
                _tripScreenUiState.update {
                    it.copy(
                        createTripDialogBoxVisibility = true
                    )
                }

            }

            UiEventClass.postCreateTrip -> {
                createTrips()
            }
        }
    }

}