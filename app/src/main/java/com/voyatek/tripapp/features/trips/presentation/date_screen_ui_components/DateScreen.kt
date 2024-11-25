package com.voyatek.tripapp.features.trips.presentation.date_screen_ui_components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.UiEventClass
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    uiEvent: (UiEventClass) -> Unit
){
    var pickedStartDate by remember {
        mutableStateOf(
            LocalDate.now()
        )
    }

    var pickedEndDate by remember {
        mutableStateOf(
            LocalDate.now()
        )
    }

    val formattedStartDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("EEE, MMM dd")
                .format(pickedStartDate)
        }
    }

    val formattedEndDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("EEE, MMM dd")
                .format(pickedEndDate)
        }
    }

    val startDateDialogState = rememberMaterialDialogState()
    val endDateDialogState = rememberMaterialDialogState()



    Scaffold (
        topBar = {
            TopAppBar(
                title ={
                    Text(
                        text = "Date",
                        fontSize = 18.sp,
                        lineHeight = 26.sp,
                        fontWeight = FontWeight.W700
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        //navController.navigate(Screen.Home.route)
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            Modifier.size(
                                width = 20.dp,
                                height = 20.dp
                            )
                        )

                    }
                },




                )


        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    //.background(color = Color.Red)
                    .height(164.dp)
            ){
                DateScreenBottomAppBarContent(
                    openEndDateDialog = {
                        endDateDialogState.show()


                    },
                    openStartDateDialog = {
                        startDateDialogState.show()

                    },
                    formattedStartDate = formattedStartDate,
                    formattedEndDate = formattedEndDate
                )
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
        ){
            item {

                //Start date Calendar dialog
                MaterialDialog (
                    dialogState = startDateDialogState,
                    buttons = {
                        positiveButton(text = "Ok"){
                            navController.popBackStack()

                        }
                        negativeButton(
                            text = "Cancel"
                        ){

                        }
                    }

                ){
                    datepicker(
                        initialDate = LocalDate.now(),
                        title = "Pick start date"
                    ){
                        pickedStartDate = it
                        uiEvent(UiEventClass.setTripStartDate(tripStartDate = formattedStartDate.toString()))
                    }

                }

                //End date Calendar dialog
                MaterialDialog (
                    dialogState = endDateDialogState,
                    buttons = {
                        positiveButton(text = "Ok"){
                            navController.popBackStack()

                        }
                        negativeButton(
                            text = "Cancel"
                        ){

                        }
                    }

                ){
                    datepicker(
                        initialDate = LocalDate.now(),
                        title = "Pick end date"
                    ){
                        pickedEndDate = it
                        uiEvent(UiEventClass.setTripEndDate(tripEndDate = formattedEndDate.toString()))

                    }

                }

            }

        }
    }
}


@Preview(
    showSystemUi = true,

    )
@Composable
fun DateScreenPreview(){
    //DateScreen()
}