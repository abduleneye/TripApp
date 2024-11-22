package com.voyatek.tripapp.features.plan_trip.presentation.ui_components.dialog_like_component

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBgColor
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBorderColor
import com.voyatek.tripapp.ui.theme.TextColorGrey
import com.voyatek.tripapp.ui.theme.TextDialogContentColor
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor

@Composable
fun DialogLikeComponents(
    icon: ImageVector,
    headerText: String,
    subText: String,
    modifier: Modifier = Modifier
    ){
    Box(
        modifier = modifier
            .height(86.dp)
            .padding(
                all = 10.dp
            )
            .clip(RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = DialogLikeContentBoxBorderColor)
            .background(DialogLikeContentBoxBgColor),
        contentAlignment = Alignment.CenterStart

    ){
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Icon(
                imageVector = icon,
                contentDescription = "Back Arrow",
                modifier =  Modifier
                    .size(
                        width = 20.dp,
                        height = 20.dp
                        ,)
                    .padding(vertical = 5.dp)
            )
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