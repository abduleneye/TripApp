package com.voyatek.tripapp.features.trips.presentation.date_screen_ui_components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateScreen(
    modifier: Modifier = Modifier
){
    Scaffold (
        topBar = {
            TopAppBar(
                title ={
                    Text(
                        text = "Date",
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


        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    //.background(color = Color.Red)
                    .height(164.dp)
            ){
                DateScreenBottomAppBarContent()
            }
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .padding(padding)
        ){
            item {

            }

        }
    }
}


@Preview(
    showSystemUi = true,

    )
@Composable
fun DateScreenPreview(){
    DateScreen()
}