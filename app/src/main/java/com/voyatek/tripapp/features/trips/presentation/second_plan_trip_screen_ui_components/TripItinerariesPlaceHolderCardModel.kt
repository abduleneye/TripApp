package com.voyatek.tripapp.features.trips.presentation.second_plan_trip_screen_ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.R
import com.voyatek.tripapp.ui.theme.CreateTripButtonBackgroundColor
import com.voyatek.tripapp.ui.theme.CreateTripButtonColor
import com.voyatek.tripapp.ui.theme.ItImgBgCol
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor

@Composable
fun TripItinerariesPlaceHolderCardModel(
    modifier: Modifier = Modifier,
    itineraryHeaderIcon: Painter,
    itineraryText: String,
    itineraryTextColor: Color,
    itineraryCardBgColor: Color,
    itineraryCenterImage: Painter,
    itineraryButtonText: String


){

    Box(
        modifier = Modifier
            .height(358.dp)
            .width(434.dp)
            .background(color = itineraryCardBgColor),
        contentAlignment = Alignment.Center
    ){
        Column(


        ){

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 10.dp,
                        top = 10.dp
                    ),
                verticalAlignment = Alignment.CenterVertically


            ){
                Icon(
                    painter = itineraryHeaderIcon,
                    contentDescription = "",
                    tint = Color.Unspecified
                )

                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                )

                Text(
                    text = itineraryText,
                    color = itineraryTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    lineHeight = 24.sp,
                    letterSpacing = (-0.5).sp

                )



            }

            //Itinerary Center Column
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 10.dp,
                        start = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    )
                    .background(color = Color.White)
                
                ,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){

                Box(
                    modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .clip(shape = RoundedCornerShape(100.dp))
                        .background(color = ItImgBgCol),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        painter = itineraryCenterImage,
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds

                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "No request yet",
                    color = YourTripHeaderTextColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    lineHeight = 24.sp,
                    letterSpacing = (-0.5).sp
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                //Button Box

                Box(
                    modifier = Modifier
                        .background(color = CreateTripButtonBackgroundColor)
                        .height(48.dp)
                        .width(228.dp)
                        .clip(shape = RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center

                ){
                    Text(
                        text = itineraryButtonText,
                        color = CreateTripButtonColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 22.sp,
                        letterSpacing = (-0.5).sp
                    )
                }

            }


        }



    }


}

@Preview()
@Composable
fun TripItinerariesPlaceHolderCardModelPreview(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TripItinerariesPlaceHolderCardModel(
            itineraryHeaderIcon = painterResource(id = R.drawable.flight_header_image),
            itineraryText = "Flights",
            itineraryCardBgColor = CreateTripButtonColor,
            itineraryCenterImage = painterResource(id = R.drawable.hmm_flight_center_image),
            itineraryButtonText = "Add Flights",
            itineraryTextColor = Color.White
        )

    }

}