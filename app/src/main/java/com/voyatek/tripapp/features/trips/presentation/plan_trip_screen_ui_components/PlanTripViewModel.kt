package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voyatek.tripapp.features.trips.core.utils.Resource
import com.voyatek.tripapp.features.trips.domain.model.CreateTripBodyModel
import com.voyatek.tripapp.features.trips.domain.repo.TripApiRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
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


    private var _tripScreenUiState = MutableStateFlow(PlanTripUiState())
    var tripScreenUiState = _tripScreenUiState.asStateFlow()

    init {
        getTrips()
    }

    private fun getTrips() {
        viewModelScope.launch {
            tripApiRepo.viewTrip().onEach { result ->
                when (result) {
                    is Resource.Error -> {
                        Log.e("Trips", "Error occurred")
                        _tripScreenUiState.update {
                            it.copy(
                                tripIsLoading = false,
                                tripLoadingStatus = "FAILED"
                            )
                        }
                    }
                    is Resource.Loading -> {
                        Log.d("Trips", "Trips Loading...")
                        _tripScreenUiState.update {
                            it.copy(
                                tripIsLoading = true,
                                tripLoadingStatus = "LOADING"
                            )
                        }
                    }
                    is Resource.Success -> {
                        if (result.data != null) {
                            _tripScreenUiState.update {
                                it.copy(
                                    plannedTrips = result.data,
                                    tripIsLoading = false,
                                    tripLoadingStatus = "SUCCESS"
                                )
                            }
                        }
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
                        _tripScreenUiState.update {
                            it.copy(
                                //createTripLoadingDialogBoxVisibility = false
                                tripCreationFailed = true,
                                tripCreationInProgress = false
                            )
                        }

                    }
                    is Resource.Loading -> {

                        _tripScreenUiState.update {
                            it.copy(
                                createTripLoadingDialogBoxVisibility = true,
                                tripCreationInProgress = true
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
                                createTripLoadingDialogBoxVisibility = true,
                                tripCreatedSuccessfully = true,
                                tripCreationInProgress = false
                            )
                        }

                    }
                }
            }.launchIn(this)

        }
    }

    private fun resetUiState(){
        _tripScreenUiState.update {
            it.copy(
                tripLocationCity ="",
                tripStartDate   = "",
                tripEndDate  = "",
                tripName  = "",
                tripTravelStyle = "",
                tripDescription = "",
                createTripDialogBoxVisibility = false,
                createTripLoadingDialogBoxVisibility = false,
                tripCreatedSuccessfully  = false,
                tripCreationFailed = false,
                tripCreationInProgress = false,
                bottomSheetVisibility = false

            )
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

            UiEventClass.hideCreateTripLoadingDialogBoxVisibility -> {
                _tripScreenUiState.update {
                    it.copy(
                        createTripLoadingDialogBoxVisibility = false,
                        createTripDialogBoxVisibility = false

                    )
                }

            }
            UiEventClass.showCreateTripLoadingDialogBox -> {

            }

            UiEventClass.onSuccesCloseLoadingDialogBox -> {
                resetUiState()



            }

            UiEventClass.hideBottomSheet -> {
                _tripScreenUiState.update {
                    it.copy(
                        bottomSheetVisibility = false
                    )
                }

            }
            UiEventClass.showBottomSheet -> {
                _tripScreenUiState.update {
                    it.copy(
                        bottomSheetVisibility = true
                    )
                }

            }

            UiEventClass.onErrorCloseLoadingDialogBox -> {

                _tripScreenUiState.update {
                    it.copy(
                        createTripLoadingDialogBoxVisibility = false,
                        createTripDialogBoxVisibility = false

                    )
                }

            }

            UiEventClass.reloadTrips -> {
                getTrips()
            }
        }
    }

}