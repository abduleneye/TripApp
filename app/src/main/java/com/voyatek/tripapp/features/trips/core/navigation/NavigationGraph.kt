package com.blue_tooth_app.bluetooth_app.features.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.voyatek.tripapp.features.trips.presentation.date_screen_ui_components.DateScreen
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.PlanTripScreen
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.PlanTripViewModel
import com.voyatek.tripapp.features.trips.presentation.plan_trip_view_trip_screen_ui_components.PlanTripViewTripScreen
import com.voyatek.tripapp.features.trips.presentation.where_location_screen_ui_components.WhereLocationScreen


@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier
) {

    val planTripViewModel = hiltViewModel<PlanTripViewModel>()
    val planTripUiState by planTripViewModel.tripScreenUiState.collectAsState()

//    Log.d(
//        "MAFVM",
//        "${planTripViewModel.tripScreenUiState.collectAsState()}"
//    )

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoutes.OgPlanTripScreen.routes) {
        composable(route = ScreenRoutes.OgPlanTripScreen.routes) {

            PlanTripScreen(
                modifier= modifier,
                navController = navController,
                uiState = planTripUiState,
                uiEvent = planTripViewModel::onEvent
            )
        }

        composable(route = ScreenRoutes.DateScreen.routes) {
            DateScreen(
                modifier = modifier,
                navController = navController,
                uiEvent = planTripViewModel::onEvent
            )

        }
        composable(route = ScreenRoutes.WhereLocationScreen.routes) {
            WhereLocationScreen(
                navController = navController,
                UiEvent = planTripViewModel::onEvent
            )

        }



        composable(route = ScreenRoutes.PlanTripViewTripScreen.routes + "/{TripName}/{StartDate}/{EndDate}/{TripLocation}/{TravelStyle}",
            arguments = listOf(
                navArgument(name = "TripName") {
                    type = NavType.StringType
                    defaultValue = "TripName"

                },
                navArgument(name = "StartDate") {
                    type = NavType.StringType
                    defaultValue = "StartDate"

                },
                navArgument(name = "EndDate") {
                    type = NavType.StringType
                    defaultValue = "EndDate"

                },
                navArgument(name = "TripLocation") {
                    type = NavType.StringType
                    defaultValue = "TripLocation"

                },
                navArgument(name = "TravelStyle") {
                    type = NavType.StringType
                    defaultValue = "TravelStyle"

                }

            )
        ){entry ->

            PlanTripViewTripScreen(
                navController = navController,
                startDate = entry.arguments?.getString("StartDate"),
                endDate = entry.arguments?.getString("EndDate"),
                tripName = entry.arguments?.getString("TripName"),
                tripLocation = entry.arguments?.getString("TripLocation"),
                travelStyle = entry.arguments?.getString("TravelStyle"),
            )

        }




    }
}