package com.blue_tooth_app.bluetooth_app.features.core.navigation

sealed class ScreenRoutes(val routes: String) {
    object OgPlanTripScreen: ScreenRoutes("og_plan_trip_screen")
    object DateScreen: ScreenRoutes("date_screen")
    object WhereLocationScreen: ScreenRoutes("where_screen")
    object PlanTripViewTripScreen: ScreenRoutes("plan_view_trip_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(routes)

            args.forEach { arg ->
                append("/$arg")
            }
        }
    }


}