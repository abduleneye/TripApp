package com.voyatek.tripapp.features.plan_trip.presentation.date_screen_ui_components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBorderColor
import com.voyatek.tripapp.ui.theme.TextDialogContentColor
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor

@Composable
fun DateHolderBoxItem(
    dateDurationHeader: String,
    dateHolderText: String,
    modifier: Modifier = Modifier
){

    Column(
        modifier = modifier
            // .width(175.dp)
            .height(50.dp)
        // .background(color = Color.Black)


    ){
        Text(
            text = dateDurationHeader,
            modifier = Modifier
                 .height(20.dp)
                // .width(253.dp)

            ,
            color = YourTripHeaderTextColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.W500,
            lineHeight = 20.sp,
            letterSpacing = (-0.5).sp
        )
        Row(
            modifier = Modifier

                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(4.dp))
                .border(width = 1.dp, color = DialogLikeContentBoxBorderColor)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround


        ){
            Text(
                text = dateHolderText,
                modifier = Modifier
                 .height(22.dp)
                // .width(253.dp)

                ,
                color = YourTripHeaderTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 22.sp,
                letterSpacing = (-0.5).sp
            )
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Start date"
            )

        }

    }

}