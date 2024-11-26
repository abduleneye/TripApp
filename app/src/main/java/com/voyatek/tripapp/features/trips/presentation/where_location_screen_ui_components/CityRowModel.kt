package com.voyatek.tripapp.features.trips.presentation.where_location_screen_ui_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.ui.theme.TextColorDarkBlue
import com.voyatek.tripapp.ui.theme.YourTripSubTextColor

@Composable
fun CityRowModel(
    countryAndCity: String,
    airportName: String,
    countryInitial: String,
    countryFlag: Int,
    selectCityEvent: ()->Unit
){
    //Parent Row
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 20.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 20.dp

            )
            .clickable {
                selectCityEvent.invoke()
            }
        ,

        horizontalArrangement = Arrangement.SpaceBetween
    ){

        Column(
            modifier = Modifier
               // .width(304.dp)
                .height(46.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "loc",
                    modifier = Modifier
                        .size(
                            width = 22.dp,
                            height = 22.dp
                        )

                )
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = countryAndCity,
                        modifier = Modifier
                             .height(24.dp)
                             .width(124.dp)
                            .padding(
                               // horizontal = 16.dp,
                                //vertical = 57.dp
                            )
                        ,
                        color = TextColorDarkBlue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W900,
                        lineHeight = 24.sp,
                        letterSpacing = (-0.5).sp)


                    Text(
                        text = airportName,
                        modifier = Modifier
                            .height(22.dp)
                            .width(56.dp)
                            .padding(
                                // horizontal = 16.dp,
                                //vertical = 57.dp
                            )
                        ,
                        color = YourTripSubTextColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                        lineHeight = 22.sp,
                        letterSpacing = (-0.5).sp
                    )
                }

            }

        }

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                modifier = Modifier
                    .height(30.dp)
                    .width(50.dp)
                ,
                painter = painterResource(id = countryFlag) ,
                contentDescription = "flag icon",
                tint = Color.Unspecified
                )
            Text(
                text = countryInitial,
                modifier = Modifier
                    .height(22.dp)
                    //.width(10.dp)
                    .padding(
                        // horizontal = 16.dp,
                        //vertical = 57.dp
                    )
                ,
                color = YourTripSubTextColor,
                fontSize = 14.sp,
                fontWeight = FontWeight.W500,
                lineHeight = 22.sp,
                letterSpacing = (-0.5).sp
            )

        }



    }

}

@Preview(
    showSystemUi = true
)
@Composable

fun CityRowModelPreview(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
        ,
        verticalArrangement = Arrangement.Center
    ){
//        CityRowModel(
//            countryAndCity = "Lagos, Nigeria",
//            airportName = "Muritala Muhammad",
//            countryInitial = "NG",
//            countryFlag = R.drawable.nig_flag
//        )

    }
}