package com.voyatek.tripapp.features.plan_trip.presentation.ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.voyatek.tripapp.ui.theme.CreateTripButtonColor
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBgColor
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBorderColor
import com.voyatek.tripapp.ui.theme.PlannedTripBoxBorderColor

@Composable
fun PlannedTripCard(
    tripImage: Painter,
    tripFloatingLocation: String,
    tripNameDesc: String,
    tripDate: String,
    tripDays: String

){
    Box (
        modifier = Modifier
            .height(384.dp)
            .width(358.dp)
            .padding(
                top = 12.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 12.dp
            )
            .clip(RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = PlannedTripBoxBorderColor)
            .background(CreateTripButtonColor),
        contentAlignment = Alignment.CenterStart

    ){
        Column(

        ){
            Box (

            ){
                Image(
                    painter = tripImage,
                    contentDescription = "Trip Image"
                )
            }
            Text(text = tripNameDesc)

            Row {
                Text(text = tripDate)
                Text(text = tripDays)
            }


        }

    }


}