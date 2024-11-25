package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun CreateTripLoadingDialogBox(
    uiEvent: (UiEventClass) -> Unit,
    loadingText: String,
    planTripUiState: PlanTripUiState,
){
    Dialog(
        onDismissRequest = {
            uiEvent(UiEventClass.hideCreateTripDialogBoxVisibility)

        },
        properties = DialogProperties(
            //securePolicy = SecureFlagPolicy.SecureOn,
        )
    ) {

        Card(

            modifier = Modifier
                .fillMaxWidth(0.7f)
                .height(200.dp)
                .clip(shape = RoundedCornerShape(4.dp))
            ,
            shape = CardDefaults.shape

        ){

            Column(
                modifier = Modifier
                    .fillMaxSize()
                // .background(color = Color.Red)
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                if (planTripUiState.tripCreationInProgress){
                    CircularProgressIndicator()
                    Text(
                        text = loadingText
                    )
                }else if(planTripUiState.tripCreatedSuccessfully){

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "SUCCESS"
                        )

                        Spacer(
                            modifier = Modifier
                                .height(64.dp)
                        )

                        Button(onClick = {

                            uiEvent(UiEventClass.onSuccesCloseLoadingDialogBox)

                        }) {
                            Text(
                                text = "CLOSE"
                            )
                        }

                    }


                }else if(planTripUiState.tripCreationFailed){
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = "AN ERROR OCCURRED"
                        )

                        Spacer(
                            modifier = Modifier
                                .height(64.dp)
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ){

                            Button(onClick = {
                                uiEvent(UiEventClass.postCreateTrip)

                            }) {
                                Text(
                                    text = "RETRY"
                                )

                            }
                            Button(onClick = {

                                uiEvent(UiEventClass.onErrorCloseLoadingDialogBox)


                            }) {
                                Text(
                                    text = "CANCEL"
                                )

                            }


                        }


                    }


            }


        }

    }
}
}