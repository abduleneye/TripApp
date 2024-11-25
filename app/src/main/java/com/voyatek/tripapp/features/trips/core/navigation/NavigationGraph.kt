package com.blue_tooth_app.bluetooth_app.features.core.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.voyatek.tripapp.features.trips.presentation.date_screen_ui_components.DateScreen
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.PlanTripScreen
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.PlanTripViewModel
import com.voyatek.tripapp.features.trips.presentation.where_screen_ui_components.WhereScreen


@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier
) {

    val planTripViewModel = hiltViewModel<PlanTripViewModel>()
    val planTripUiState by planTripViewModel.tripScreenUiState.collectAsState()

    Log.d(
        "MAFVM",
        "${planTripViewModel.tripScreenUiState.collectAsState()}"
    )

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
        composable(route = ScreenRoutes.WhereScreen.routes) {
            WhereScreen(
                navController = navController,
                UiEvent = planTripViewModel::onEvent
            )

        }




    }
}