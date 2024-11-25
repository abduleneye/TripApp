package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.dialog_like_component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.R
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBgColor
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBorderColor
import com.voyatek.tripapp.ui.theme.TextDialogContentColor
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor

@Composable
fun DialogLikeComponents(
    icon: Int,
    headerText: String,
    subText: String,
    modifier: Modifier = Modifier
    ){
    Box(
        modifier = modifier
           // .fillMaxWidth()
            .height(86.dp)
            .width(302.dp)
            .padding(
//                start = 10.dp,
//                end = 10.dp
                start = 8.dp,
                end = 8.dp

            )
            .clip(RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = DialogLikeContentBoxBorderColor)
            .background(DialogLikeContentBoxBgColor),
        contentAlignment = Alignment.CenterStart

    ){
        Row (
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 10.dp)
            ,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier =  Modifier
                    .size(
                        width = 20.dp,
                        height = 20.dp
                        ,)
                   // .padding(vertical = 5.dp)
            ){
                Icon(
                    painter = painterResource(id = icon) ,
                    contentDescription = "Calendar icon",

                )
            }

            Column {
                Text(text = headerText,
                    modifier = Modifier
                    // .height(26.dp)
                    // .width(253.dp)
                    .padding(
                        horizontal = 16.dp,
                        //vertical = 57.dp
                    )
                    ,
                    color = TextDialogContentColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 20.sp,
                    letterSpacing = (-0.5).sp)
                Text(text = subText,
                    modifier = Modifier
                        // .height(26.dp)
                        // .width(253.dp)
                        .padding(
                            horizontal = 16.dp,
                            //vertical = 57.dp
                        )
                    ,
                    color = YourTripHeaderTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W900,
                    lineHeight = 22.sp,
                    letterSpacing = (-0.5).sp)
            }
        }

    }

}

@Preview(
    showSystemUi = true
)
@Composable
fun PlanTripScreenPreview(){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DialogLikeComponents(
            icon = R.drawable.blank_calendar,
            headerText = "Start Date",
            subText = "Enter Date",
            modifier = Modifier
        )

    }

}