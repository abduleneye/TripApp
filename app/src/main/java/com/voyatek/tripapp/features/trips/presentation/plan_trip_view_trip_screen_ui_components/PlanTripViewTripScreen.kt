package com.voyatek.tripapp.features.trips.presentation.plan_trip_view_trip_screen_ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.voyatek.tripapp.R
import com.voyatek.tripapp.ui.theme.ActivityCardBgColor
import com.voyatek.tripapp.ui.theme.ActivityMakerCardBgColor
import com.voyatek.tripapp.ui.theme.BlackTextColor
import com.voyatek.tripapp.ui.theme.CreateTripButtonBackgroundColor
import com.voyatek.tripapp.ui.theme.CreateTripButtonColor
import com.voyatek.tripapp.ui.theme.FlightMakerCardBgColor
import com.voyatek.tripapp.ui.theme.HotelCardBgColor
import com.voyatek.tripapp.ui.theme.TreeBoundingBoxColor
import com.voyatek.tripapp.ui.theme.TripDetailDateBgColor
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor
import com.voyatek.tripapp.ui.theme.YourTripSubTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanTripViewTripScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    tripName: String?,
    startDate: String?,
    endDate: String?,
    tripLocation: String?,
    travelStyle: String?
){
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
                        navController.popBackStack()
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
    ) {padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
        ){
           item {

               //Trip detail header Image
               Image(
                   painter = painterResource(id = R.drawable.second_plant_trip_top_bg_img),
                   contentDescription = "",
                   contentScale = ContentScale.Fit,
                   modifier = Modifier
                       .fillMaxSize()
                       .fillMaxSize()
                       //.padding(top = 64.dp)
               )
               //Trip detail section box
               Column(
                   modifier = Modifier
                       .padding(
                           top = 24.dp,
                           start = 16.dp,
                           end = 16.dp
                       )


               ){
                   //Trip detail date box
                   Box(
                       modifier = Modifier
                           .width(224.dp)
                           .height(28.dp)
                           .clip(shape = RoundedCornerShape(4.dp))
                           .background(
                               color = TripDetailDateBgColor
                           ),
                       contentAlignment = Alignment.Center
                   ){
                       Row(
                           modifier = 
                               Modifier
                                   .fillMaxWidth(),
                           verticalAlignment = Alignment.CenterVertically
                       ){
                           Icon(
                               painter = painterResource(id = R.drawable.calendar_blank),
                               contentDescription = ""
                           )

                           if (startDate != null) {
                               Text(
                                   text = startDate,
                                   modifier = Modifier
                                       // .height(26.dp)
                                       // .width(253.dp)
                                       .padding(
                                           horizontal = 8.dp,
                                           //vertical = 57.dp
                                       ),
                                   color = YourTripHeaderTextColor,
                                   fontSize = 12.sp,
                                   fontWeight = FontWeight.W500,
                                   lineHeight = 20.sp,
                                   letterSpacing = (-0.5).sp
                               )
                           }

                           Icon(
                               painter = painterResource(id = R.drawable.arrow_right),
                               contentDescription = ""
                           )

                           if (endDate != null) {
                               Text(
                                   text = endDate,
                                   modifier = Modifier
                                       // .height(26.dp)
                                       // .width(253.dp)
                                       .padding(
                                           horizontal = 8.dp,
                                           //vertical = 57.dp
                                       ),
                                   color = YourTripHeaderTextColor,
                                   fontSize = 12.sp,
                                   fontWeight = FontWeight.W500,
                                   lineHeight = 20.sp,
                                   letterSpacing = (-0.5).sp
                               )
                           }



                       }

                   }
                   Spacer(modifier =
                       Modifier.height(4.dp)
                   )

                   //Trip Desc or name
                   if (tripName != null) {
                       Text(
                           text = tripName,
                           color = BlackTextColor,
                           fontSize = 16.sp,
                           fontWeight = FontWeight.W700,
                           lineHeight = 24.sp,
                           letterSpacing = (-0.5).sp
                       )
                   }

                   Spacer(modifier =
                   Modifier.height(4.dp)
                   )

                   //Trip Destination and style or type
                   Text(
                       text = "${tripLocation} | ${travelStyle}",
                       color = YourTripSubTextColor,
                       fontSize = 12.sp,
                       fontWeight = FontWeight.W500,
                       lineHeight = 20.sp,
                       letterSpacing = (-0.5).sp
                   )


               }

               //Trip extension row, colab, share and more
               Row(
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(
                           top = 24.dp,
                           start = 16.dp,
                           end = 16.dp
                       ),
                   horizontalArrangement = Arrangement.SpaceBetween,
                   verticalAlignment = Alignment.CenterVertically

               ){
                   Row(
                       modifier = Modifier

                           .height(46.dp)
                           .width(116.dp)
                           .border(
                               width = 2.dp,
                               color = CreateTripButtonBackgroundColor,
                               shape = RoundedCornerShape(4.dp)

                           )

                       ,
                       verticalAlignment = Alignment.CenterVertically,
                       horizontalArrangement = Arrangement.Center




                   ){

                       Icon(
                           painter = painterResource(id = R.drawable.hand_shake),
                           contentDescription = "",
                           tint = Color.Unspecified
                       )

                       Spacer(
                           modifier = Modifier
                               .width(5.dp)
                       )

                       Text(
                           text = "Trip Collaboration",
                           color = YourTripHeaderTextColor,
                           fontSize = 14.sp,
                           fontWeight = FontWeight.W500,
                           lineHeight = 22.sp,
                           letterSpacing = (-0.5).sp,
                           overflow = TextOverflow.Ellipsis
                       )

                   }

                   Row (
                       modifier = Modifier

                           .height(46.dp)
                           .width(116.dp)
                           .border(
                               width = 2.dp,
                               color = CreateTripButtonBackgroundColor,
                               shape = RoundedCornerShape(4.dp)

                           )
                       ,
                       verticalAlignment = Alignment.CenterVertically,
                       horizontalArrangement = Arrangement.Center

                   ){
                       Icon(
                           painter = painterResource(id = R.drawable.share_fat),
                           contentDescription = "",
                           tint = Color.Unspecified

                       )

                       Spacer(
                           modifier = Modifier
                               .width(5.dp)
                       )

                       Text(
                           text = "Share Trip",
                           color = YourTripHeaderTextColor,
                           fontSize = 14.sp,
                           fontWeight = FontWeight.W500,
                           lineHeight = 22.sp,
                           letterSpacing = (-0.5).sp
                       )

                   }

                   Icon(
                       painter = painterResource(id = R.drawable.dots_three),
                       contentDescription = "",
                       tint = Color.Unspecified,
                               modifier = Modifier
//                           .graphicsLayer (
//                               rotationZ = 90f
//                           )
                   )

               }

               // Itinerary Maker Section
               Column(

                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(all = 14.dp)

               ){
                   TripItineraryCardModel(
                       headerText = "Activities",
                       subText = "Build, personalize, and optimize your itineraries with our trip planner",
                       cardColour = ActivityMakerCardBgColor,
                       buttonText = "Add Activities",
                       buttonColor = FlightMakerCardBgColor,
                       buttonTexColor = CreateTripButtonColor,
                       headerTextColor = CreateTripButtonColor,
                       subTextColor = CreateTripButtonColor
                   )

                   Spacer(modifier =
                   Modifier.height(8.dp)
                   )

                   TripItineraryCardModel(
                       headerText = "Hotels",
                       subText = "Build, personalize, and optimize your itineraries with our trip planner",
                       cardColour = TreeBoundingBoxColor,
                       buttonText = "Add Activities",
                       buttonColor = FlightMakerCardBgColor,
                       buttonTexColor = Color.White,
                       headerTextColor = BlackTextColor,
                       subTextColor = YourTripHeaderTextColor
                   )

                   Spacer(modifier =
                   Modifier.height(8.dp)
                   )

                   TripItineraryCardModel(
                       headerText = "Flights",
                       subText = "Build, personalize, and optimize your itineraries with our trip planner",
                       cardColour = FlightMakerCardBgColor,
                       buttonText = "Add Activities",
                       buttonColor = Color.White,
                       buttonTexColor = FlightMakerCardBgColor,
                       headerTextColor = Color.White,
                       subTextColor = Color.White
                   )

               }

               //Trip Itineraries Header
               Column(
                   modifier = Modifier
                       .padding(
                           top = 16.dp,
                           start = 16.dp,
                           end = 16.dp
                       )

               ) {
                   Text(
                       text = "Trip itineraries",
                       color = YourTripHeaderTextColor,
                       fontSize = 16.sp,
                       fontWeight = FontWeight.W700,
                       lineHeight = 24.sp,
                       letterSpacing = (-0.5).sp

                   )

                   Text(
                       text = "Your Trip itineraries are place here",
                       color = YourTripSubTextColor,
                       fontSize = 12.sp,
                       fontWeight = FontWeight.W500,
                       lineHeight = 20.sp,
                       letterSpacing = (-0.5).sp
                   )
               }

               //Trip Itineraries place holder
               Column(
                   modifier = Modifier
                       .padding(
                           top = 16.dp,
                           start = 16.dp,
                           end = 16.dp
                       )
               ){

                   TripItinerariesPlaceHolderCardModel(
                       itineraryHeaderIcon = painterResource(id = R.drawable.flight_header_image),
                       itineraryText = "Flights",
                       itineraryCardBgColor = CreateTripButtonColor,
                       itineraryCenterImage = painterResource(id = R.drawable.hmm_flight_center_image),
                       itineraryButtonText = "Add Flights",
                       itineraryTextColor = YourTripHeaderTextColor
                   )
                   Spacer(
                       modifier = Modifier
                           .height(8.dp)
                   )



                   TripItinerariesPlaceHolderCardModel(
                       itineraryHeaderIcon = painterResource(id = R.drawable.hotel_header_image),
                       itineraryText = "Hotels",
                       itineraryCardBgColor = HotelCardBgColor,
                       itineraryCenterImage = painterResource(id = R.drawable.hmm_hotel_center_image),
                       itineraryButtonText = "Add Flights",
                       itineraryTextColor = CreateTripButtonColor
                   )

                   Spacer(
                       modifier = Modifier
                           .height(8.dp)
                   )

                   TripItinerariesPlaceHolderCardModel(
                       itineraryHeaderIcon = painterResource(id = R.drawable.activity_header_image),
                       itineraryText = "Activities",
                       itineraryCardBgColor = ActivityCardBgColor,
                       itineraryCenterImage = painterResource(id = R.drawable.hmm_activity_center_image),
                       itineraryButtonText = "Add Flights",
                       itineraryTextColor = CreateTripButtonColor
                   )



               }


           }

        }


    }

}

@Preview(
    showSystemUi = true
)
@Composable
fun SecondPlanTripScreenPreview(){
    //PlanTripViewTripScreen()
}