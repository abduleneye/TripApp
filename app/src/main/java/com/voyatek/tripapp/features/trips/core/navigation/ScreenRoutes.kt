package com.blue_tooth_app.bluetooth_app.features.core.navigation

sealed class ScreenRoutes(val routes: String) {
    object OgPlanTripScreen: ScreenRoutes("og_plan_trip_screen")
    object DateScreen: ScreenRoutes("date_screen")
    object WhereScreen: ScreenRoutes("where_screen")

}