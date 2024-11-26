package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components

sealed class UiEventClass {

    data class setTripLocation(var tripLocation: String): UiEventClass()

    data class setTripStartDate(var tripStartDate: String): UiEventClass()

    data class setTripEndDate(var tripEndDate: String): UiEventClass()

    data class setTripName (var tripName: String): UiEventClass()

    data class setTripTravelStyle (var tripTravelStyle: String): UiEventClass()

    data class setTripDescription (var tripDescription: String): UiEventClass()

    object showCreateTripDialogBox: UiEventClass()

    object hideCreateTripDialogBoxVisibility: UiEventClass()

    object showCreateTripLoadingDialogBox: UiEventClass()

    object hideCreateTripLoadingDialogBoxVisibility: UiEventClass()

    object showBottomSheet: UiEventClass()

    object hideBottomSheet: UiEventClass()

    object postCreateTrip: UiEventClass()

    object onSuccesCloseLoadingDialogBox: UiEventClass()

    object onErrorCloseLoadingDialogBox: UiEventClass()

    object reloadTrips: UiEventClass()







}