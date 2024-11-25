package com.voyatek.tripapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.PlanTripScreen
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.PlanTripViewModel
import com.voyatek.tripapp.ui.theme.VoyaTekTripAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val todoViewModel = hiltViewModel<PlanTripViewModel>()

            VoyaTekTripAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Log.d(
                        "MAFVM",
                        "${todoViewModel.tripScreenUiState.collectAsState()}"
                    )
                        PlanTripScreen(modifier = Modifier.padding(innerPadding))

                                    }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VoyaTekTripAppTheme {
        Greeting("Android")
    }
}