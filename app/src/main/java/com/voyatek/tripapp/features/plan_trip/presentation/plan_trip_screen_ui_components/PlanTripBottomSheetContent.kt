package com.voyatek.tripapp.features.plan_trip.presentation.plan_trip_screen_ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.R
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBgColor
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBorderColor
import com.voyatek.tripapp.ui.theme.TextDialogContentColor
import com.voyatek.tripapp.ui.theme.TreeBoundingBoxColor
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor

@Composable
fun PlanTripBottomSheetContent(
    closeBottomSheet:  () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

                modifier = Modifier
                    .padding(all = 16.dp)
            .fillMaxSize(),
    ){

            //Bottom sheet header
            Column(
                modifier = Modifier
                   // .padding(top = 64.dp)

            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Box(
                        modifier =
                            Modifier.size(44.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(color = TreeBoundingBoxColor)
                        ,
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.tree_btm_sht),
                            contentDescription = "",
                            tint = Color.Unspecified
                        )
                    }

                    Icon(
                        modifier = Modifier
                            .clickable {
                                closeBottomSheet.invoke()
                            },
                        imageVector = Icons.Default.Close,
                        contentDescription = "",

                    )

                }

            }
            //Create a trip header
            Column(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .fillMaxWidth()
            ){
                Text(
                    text = "Create a Trip",
                    modifier = Modifier
                         //.height(22.dp)
                       //  .width(78.dp)
//                        .padding(
//                            vertical = 89.dp,
//                            horizontal = 57.dp
//                        )
                    ,
                    color = YourTripHeaderTextColor,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W700,
                    lineHeight = 22.sp,
                    letterSpacing = (-0.5).sp
                )
                Text(
                    text = "Let's Go! Build You Next Adventure",
                    modifier = Modifier
                        .height(20.dp)
                       // .width(358.dp)
//                        .padding(
//                            vertical = 89.dp,
//                            horizontal = 57.dp
//                        )
                    ,
                    color = YourTripHeaderTextColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.W500,
                    lineHeight = 20.sp,
                    letterSpacing = (-0.5).sp
                )
            }


            //Trip Form
            Column(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxSize()
                  //  .padding(16.dp)
            ){
                //Trip name and text field Column
                Column(

                ){

                    Text(
                        text = "TripName",
                        modifier = Modifier
                        //    .height(22.dp)
                          //  .width(62.dp)
//                            .padding(
//                                vertical = 89.dp,
//                                horizontal = 57.dp
//                            )
                        ,
                        color = YourTripHeaderTextColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 22.sp,
                        letterSpacing = (-0.5).sp
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onValueChange = {

                        },
                        value = "",
                        label = {
                            Text(
                                text = "Enter the Trip name"
                            )
                        }
                    )

                }
                
                Spacer(modifier = Modifier
                    .height(16.dp)
                )

                //Travel style and selection box
                DropDownMenuTwo()

                Spacer(modifier = Modifier
                    .height(16.dp)
                )

                //Trip Desc and text field Column
                Column(){

                    Text(
                        text = "Trip Description",
                        modifier = Modifier
//                            .height(22.dp)
////                            .width(62.dp)
//                            .padding(
//                                vertical = 89.dp,
//                                horizontal = 57.dp
//                            )
                        ,
                        color = YourTripHeaderTextColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 22.sp,
                        letterSpacing = (-0.5).sp
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(188.dp)
                        ,
                        onValueChange = {

                        },
                        value = "",
                        label = {
                            Text(
                                text = "Tell us more about the trip"
                            )
                        }
                    )

                }


            }




    }

}

@Preview(showSystemUi = true)
@Composable
fun PlanTripBottomSheetContentPreview(){
    PlanTripBottomSheetContent(
        closeBottomSheet = {}
    )
}