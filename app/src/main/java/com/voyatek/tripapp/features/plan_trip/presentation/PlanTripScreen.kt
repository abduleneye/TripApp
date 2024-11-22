package com.voyatek.tripapp.features.plan_trip.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.features.plan_trip.presentation.ui_components.dialog_like_component.DialogLikeComponents
import com.voyatek.tripapp.ui.theme.CreateTripButtonBackgroundColor
import com.voyatek.tripapp.ui.theme.CreateTripButtonColor
import com.voyatek.tripapp.ui.theme.PlannedTripsDropDownParentBoxColor
import com.voyatek.tripapp.ui.theme.TextColorDarkBlue
import com.voyatek.tripapp.ui.theme.TextColorGrey
import com.voyatek.tripapp.ui.theme.TextDialogContentColor
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor
import com.voyatek.tripapp.ui.theme.YourTripSubTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanTripScreen(){
    
    Scaffold (
        topBar = {
            TopAppBar(
                title ={
                    Text(
                        text = "Plan a Trip",
                        fontSize = 18.sp,
                        lineHeight = 26.sp,
                        fontWeight = FontWeight.W700
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        //navController.navigate(Screen.Home.route)
                        //navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back Arrow",
                            Modifier.size(
                                width = 20.dp,
                                height = 20.dp
                            )
                        )

                    }
                },




    )

}
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            //Initial Contents with omo image bg
            Box(
                modifier = Modifier
                    .width(390.dp)
                   // .height(549.dp)
                    .padding(vertical = 0.dp)
                    .background(color = Color.LightGray)
            ){
                Column (

                ){
                    Text(
                        text = "Plan Your Dream Trip in Minutes",
                        modifier = Modifier
                           // .height(26.dp)
                           // .width(253.dp)
                            .padding(
                                horizontal = 16.dp,
                                vertical = 26.dp
                            )
                        ,
                        color = TextColorDarkBlue,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W700,
                        lineHeight = 26.sp,
                        letterSpacing = (-0.5).sp




                    )
                    Text(
                        text = "Build, personalize, and optimize your itineraries with our trip planner. Perfect for getaways, remote workcations, and any spontaneous escapade.",
                        modifier = Modifier
                            // .height(26.dp)
                            // .width(253.dp)
                            .padding(
                                horizontal = 16.dp,
                                //vertical = 57.dp
                            )
                        ,
                        color = TextColorGrey,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 22.sp,
                        letterSpacing = (-0.5).sp
                    )

                    //Dialog like box to create trip
                    Box (
                        modifier = Modifier
                            .width(334.dp)
                            .height(278.dp)
                            .padding(
                                vertical = 20.dp,
                                horizontal = 28.dp
                            )
                            .clip(RoundedCornerShape(4.dp))
                            .background(CreateTripButtonColor),
                        ){
                        //Dialog like content
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ){
                            DialogLikeComponents(
                                icon = Icons.Default.LocationOn,
                                headerText = "Where to?",
                                subText = "Select City",
                               // modifier = Modifier.weight(1f)

                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween

                            ){
                                DialogLikeComponents(
                                    icon = Icons.Default.LocationOn,
                                    headerText = "Start Date",
                                    subText = "Enter Date",
                                    modifier = Modifier.weight(1f)
                                )
                                DialogLikeComponents(
                                    icon = Icons.Default.LocationOn,
                                    headerText = "End Date",
                                    subText = "Enter Date",
                                    modifier = Modifier.weight(1f)

                                )






                            }

                            //create trip button
                            Box (
                                modifier = Modifier
                                    .height(62.dp)
                                    .width(302.dp)
                                    .padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                        top = 8.dp,
                                        bottom = 8.dp
                                    )
                                    .clip(RoundedCornerShape(4.dp))
                                    //.border(width = )
                                    .background(CreateTripButtonBackgroundColor),
                                contentAlignment = Alignment.Center
                            ){
                                Text(
                                    text = "Create a Trip",
                                            modifier = Modifier
                                            // .height(26.dp)
                                            // .width(253.dp)
                                            .padding(
                                            horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                                ,
                                color = CreateTripButtonColor,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W900,
                                lineHeight = 22.sp,
                                letterSpacing = (-0.5).sp
                                )

                            }

                        }

                    }





                }
            }


            //You Trip Header Box and Content
            Box(
                modifier = Modifier
                    .width(263.dp)
                    .height(44.dp)
                    .padding(
                        start = 16.dp,
                      //  top = 720.dp
                    )
            ){
                Column(
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = "Your Trips",
                        modifier = Modifier
                            // .height(26.dp)
                            // .width(253.dp)
                            .padding(
                               // horizontal = 16.dp,
                                //vertical = 57.dp
                            )
                        ,
                        color = YourTripHeaderTextColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        lineHeight = 24.sp,
                        letterSpacing = (-0.5).sp)

                    Text(text = "Your trip itineraries and  planned trips are placed here",
                        modifier = Modifier
                            // .height(26.dp)
                            // .width(253.dp)
                            .padding(
                                //horizontal = 16.dp,
                                //vertical = 57.dp
                            )
                        ,
                        color = YourTripSubTextColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 20.sp,
                        letterSpacing = (-0.5).sp
                    )
                }
            }

            //Planned trips drop down parent box

            Box(
                modifier = Modifier
                    .width(358.dp)
                    .height(54.dp)
                    .padding(
                        all = 8.dp
                        //  top = 720.dp
                    )
                    .clip(RoundedCornerShape(4.dp))
                    .background(color = PlannedTripsDropDownParentBoxColor)

            ){
                //Planned trips drop down box
                    Row(
                        modifier = Modifier
                            .width(342.dp)
                            .height(38.dp)
                            .padding(
                                all = 8.dp
                                //  top = 720.dp
                            )
                            .clip(RoundedCornerShape(4.dp))
                            .background(color = CreateTripButtonColor)
                        ,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ){
                        Text(
                            text = "Planned Trips",
                            modifier = Modifier
                                // .height(26.dp)
                                // .width(253.dp)
                                .padding(
                                    horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                            ,
                            color = TextDialogContentColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 22.sp,
                            letterSpacing = (-0.5).sp
                        )
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Drop down arrow"
                        )
                    }



            }

            //Planned Trip Cards List Section




        }
    }
}

@Preview
@Composable
fun PlanTripScreenPreview(){
    PlanTripScreen()
}