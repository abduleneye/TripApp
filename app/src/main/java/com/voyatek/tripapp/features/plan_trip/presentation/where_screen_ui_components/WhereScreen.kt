package com.voyatek.tripapp.features.plan_trip.presentation.where_screen_ui_components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voyatek.tripapp.R
import com.voyatek.tripapp.ui.theme.SelectCityTextColor
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WhereScreen(
    modifier: Modifier = Modifier
){
    Scaffold (
        topBar = {
            TopAppBar(
                title ={
                    Text(
                        text = "Where",
                        fontSize = 18.sp,
                        lineHeight = 26.sp,
                        fontWeight = FontWeight.W700
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        //navController.navigate(Screen.Home.route)
                        //navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Back Arrow",
                            Modifier.size(
                                width = 20.dp,
                                height = 20.dp
                            )
                        )

                    }
                },




                )

        }
    ) { padding->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
            ,
            //horizontalAlignment = Alignment.CenterHorizontally

        ){
            item{
                //Search Section Container
                Column (
                    modifier = Modifier
                           .padding(all = 16.dp)
                        .width(358.dp)
                        .height(112.dp)

                    ){
                        Text(
                            text = "Please select a city",
                                    modifier = Modifier
                                    .height(22.dp)
                               // .width(110.dp)
                                .padding(
                                    // horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                            ,
                            color = SelectCityTextColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 22.sp,
                            letterSpacing = (-0.5).sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        //Search box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()


                        ){
                            OutlinedTextField(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                onValueChange = {

                                },
                                value = "Lag",
                                textStyle = TextStyle(
                                    color = YourTripHeaderTextColor,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W500,
                                    lineHeight = 24.sp,
                                    letterSpacing = (-0.5).sp

                                )
                            )

                        }
                    }

                //City Column
                Column(
                   // horizontalAlignment = Alignment.Start
                    modifier = Modifier
                      //  .fillMaxSize()

                ){

                    CityRowModel(
                        countryAndCity = "Lagos, Nigeria",
                        airportName = "Muritala Muhammad",
                        countryInitial = "NG",
                        countryFlag = R.drawable.nig_flag
                    )
                    CityRowModel(
                        countryAndCity = "Laghout, Algeria",
                        airportName = "Laghout",
                        countryInitial = "DZ",
                        countryFlag = R.drawable.algeria_flag
                    )
                    CityRowModel(
                        countryAndCity = "Doha, Qatar",
                        airportName = "Doha",
                        countryInitial = "QA",
                        countryFlag = R.drawable.qatar_flag_img
                    )
                    CityRowModel(
                        countryAndCity = "Doha, Qatar",
                        airportName = "Doha",
                        countryInitial = "QA",
                        countryFlag = R.drawable.qatar_flag_img
                    )
                    CityRowModel(
                        countryAndCity = "Doha, Qatar",
                        airportName = "Doha",
                        countryInitial = "QA",
                        countryFlag = R.drawable.qatar_flag_img
                    )
                    CityRowModel(
                        countryAndCity = "Doha, Qatar",
                        airportName = "Doha",
                        countryInitial = "QA",
                        countryFlag = R.drawable.qatar_flag_img
                    )



                }



            }

        }



    }

}

@Preview(
    showSystemUi = true,

    )
@Composable
fun WhereScreenPreview(){
    WhereScreen()
}