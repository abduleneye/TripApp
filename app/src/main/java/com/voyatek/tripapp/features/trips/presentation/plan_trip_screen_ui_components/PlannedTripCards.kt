package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.R
import com.voyatek.tripapp.ui.theme.CreateTripButtonBackgroundColor
import com.voyatek.tripapp.ui.theme.CreateTripButtonColor
import com.voyatek.tripapp.ui.theme.PlannedTripBoxBorderColor
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor

@Composable
fun PlannedTripCard(
    tripImage: Painter,
    tripFloatingLocation: String,
    tripNameDesc: String,
    tripDate: String,
    tripDays: String,
    onViewButtonClicked: ()->Unit

){
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(384.dp)
            //.width(358.dp)
            .padding(
//                top = 12.dp,
//                start = 16.dp,
//                end = 16.dp,
//                bottom = 12.dp
            )
            .clip(RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = PlannedTripBoxBorderColor)
            .background(CreateTripButtonColor),
        contentAlignment = Alignment.Center

    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(14.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(14.dp),

        ){
            //Planned trip card image box
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    //.width(326.dp)
                    .height(230.dp)
                    .clip(RoundedCornerShape(6.dp))


            ){
                Image(
                    painter = tripImage,
                    contentDescription = "Trip Image",
                    modifier = Modifier
                        .fillMaxSize()
//                        .width(326.dp)
//                        .height(230.dp)

                )
                Box(
                    modifier =
                        Modifier
                            //.width(100.dp)
                            .fillMaxWidth()
                            .height(38.dp)
                            .offset(
                                y = 34.dp,
                                x = (-16).dp
                            )
                            .clip(RoundedCornerShape(4.dp))
                            .align(Alignment.TopEnd)
                            //.padding(top = 20.dp)
                    ,
                    contentAlignment = Alignment.Center
                ) {

                    Box(
                        modifier =
                        Modifier
                            .width(100.dp)
                            .height(38.dp)
                            .background(brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.LightGray,
                                    Color.Gray
                                )
                            ))

                            //.shadow()
                            //.clip(RoundedCornerShape(4.dp))
                            .align(Alignment.TopEnd)
                        .padding(all = 8.dp)
                        ,
                        contentAlignment = Alignment.Center
                    ){
                        Text(
                            text = tripFloatingLocation,
                            modifier = Modifier
                                // .height(26.dp)
                                // .width(253.dp)
                                .padding(
                                    //horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                            ,
                            color = CreateTripButtonColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 22.sp,
                            letterSpacing = (-0.5).sp
                        )
                }


                }
            }
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    //.width(326.dp)
                    .height(54.dp)
                    .clip(RoundedCornerShape(6.dp))


            ){
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Text(
                        text = tripNameDesc,
                        modifier = Modifier
                            // .height(26.dp)
                            // .width(253.dp)
                            .padding(
                                //horizontal = 16.dp,
                                //vertical = 57.dp
                            )
                        ,
                        color = YourTripHeaderTextColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W700,
                        lineHeight = 24.sp,
                        letterSpacing = (-0.5).sp
                        )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            text = tripDate,
                            modifier = Modifier
                                // .height(26.dp)
                                // .width(253.dp)
                                .padding(
                                    //horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                            ,
                            color = YourTripHeaderTextColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 22.sp,
                            letterSpacing = (-0.5).sp
                            )
                        Text(text = tripDays,
                            modifier = Modifier
                                // .height(26.dp)
                                // .width(253.dp)
                                .padding(
                                    //horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                            ,
                            color = YourTripHeaderTextColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 22.sp,
                            letterSpacing = (-0.5).sp,
                            textAlign = TextAlign.Right
                            )
                    }
                }



            }


            //view trip button
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    //.width(326.dp)
                    .padding(
//                        start = 16.dp,
//                        end = 16.dp,
//                        top = 8.dp,
//                        bottom = 8.dp
                    )
                    .clip(RoundedCornerShape(4.dp))
                    .clickable {
                        onViewButtonClicked.invoke()
                    }
                    .background(CreateTripButtonBackgroundColor),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "View",
                    modifier = Modifier
                        // .height(26.dp)
                        // .width(253.dp)
                        .padding(
                            //horizontal = 16.dp,
                            //vertical = 57.dp
                        )
                    ,
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

@Preview
@Composable
fun PlannedTripCardPreview(){
    PlannedTripCard(
        tripImage = painterResource(id = R.drawable.trip_card_image),
        tripFloatingLocation = "Paris",
        tripNameDesc = "Bahamas Family Trip",
        tripDate = "19th April 2024",
        tripDays = "5 Days",
        onViewButtonClicked = {}
    )
}