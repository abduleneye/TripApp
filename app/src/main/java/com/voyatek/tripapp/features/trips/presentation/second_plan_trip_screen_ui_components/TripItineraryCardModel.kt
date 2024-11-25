package com.voyatek.tripapp.features.trips.presentation.second_plan_trip_screen_ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TripItineraryCardModel(
    headerText: String,
    subText: String,
    headerTextColor: Color,
    subTextColor: Color,
    cardColour: Color,
    buttonText: String,
    buttonColor: Color,
    buttonTexColor: Color

    ){



    Box(
        modifier = Modifier
            .background(color = cardColour)
            .height(193.dp)
            .width(358.dp)
            .clip(shape = RoundedCornerShape(12.dp))

    ){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(all = 20.dp),
            verticalArrangement = Arrangement.SpaceAround
        ){

            //Text Column
            Column(

            ){
                Text(
                    text = headerText,
                    color = headerTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    lineHeight = 24.sp,
                    letterSpacing = (-0.5).sp
                )

                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )

                Text(
                    text = subText,
                    color = subTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 22.sp,
                    letterSpacing = (-0.5).sp



                )

            }




            //Button Box

            Box(
                modifier = Modifier
                    .background(color = buttonColor)
                    .height(48.dp)
                    .width(330.dp)
                    .clip(shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center

            ){
                Text(
                    text = buttonText,
                    color = buttonTexColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 22.sp,
                    letterSpacing = (-0.5).sp
                )
            }

        }

    }


}

@Preview(
    showSystemUi = true
)
@Composable
fun TripItineraryCardModelPreview(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TripItineraryCardModel(
            headerText = "Activities",
            subText = "Build, personalize, and optimize your itineraries with our trip planner",
            cardColour = Color.Black,
            buttonText = "Add Activities",
            buttonColor = Color.Green,
            buttonTexColor = Color.White,
            headerTextColor = Color.White,
            subTextColor = Color.White
        )
    }
}