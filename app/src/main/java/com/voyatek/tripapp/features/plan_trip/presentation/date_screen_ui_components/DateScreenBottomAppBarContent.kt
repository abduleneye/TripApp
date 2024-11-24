package com.voyatek.tripapp.features.plan_trip.presentation.date_screen_ui_components

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.ui.theme.CreateTripButtonBackgroundColor
import com.voyatek.tripapp.ui.theme.CreateTripButtonColor

@Composable
fun DateScreenBottomAppBarContent(){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            // .background(color = Color.Red)
            .fillMaxSize()

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(74.dp)
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
            //.background(color = Color.LightGray)

            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            DateHolderBoxItem(
                dateDurationHeader = "Start Date",
                dateHolderText = "Sat, Feb 2",
                modifier = Modifier.weight(0.5f)
            )

            Spacer(
                modifier = Modifier.width(6.dp)
            )

            DateHolderBoxItem(
                dateDurationHeader = "End Date",
                dateHolderText = "Wed, Feb 5",
                modifier = Modifier.weight(0.5f)
            )

        }

        //choose date  button
        Box (
            modifier = Modifier
                //.fillMaxWidth()
                //.fillMaxHeight()
                .height(48.dp)
                .width(358.dp)
                .padding(
                    start = 16.dp,
                     end = 16.dp,
                    //top = 8.dp,
                    // bottom = 8.dp
                )
                .clip(RoundedCornerShape(4.dp))
                .background(CreateTripButtonBackgroundColor),
            contentAlignment = Alignment.Center
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .height(62.dp)
//                                        .width(302.dp)
//                                        .padding(
//                                            start = 12.dp,
//                                            end = 12.dp,
//                                            top = 8.dp,
//                                            bottom = 8.dp
//                                        )
//                                        .clip(RoundedCornerShape(4.dp))
//                                        //.border(width = )
//                                        .background(CreateTripButtonBackgroundColor),
//                                    contentAlignment = Alignment.Center
        ){
            Text(
                text = "Choose Date",
                modifier = Modifier
                    .height(22.dp)
                    .width(79.dp)
                    .padding(
                        //horizontal = 16.dp,
                        //vertical = 57.dp
                    )
                ,
                color = CreateTripButtonColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 22.sp,
                letterSpacing = (-0.5).sp
            )

        }


    }

}