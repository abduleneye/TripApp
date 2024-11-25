package com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components

import CreateTripConfirmationDialogBox
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.blue_tooth_app.bluetooth_app.features.core.navigation.ScreenRoutes
import com.voyatek.tripapp.R
import com.voyatek.tripapp.features.trips.presentation.plan_trip_screen_ui_components.dialog_like_component.DialogLikeComponents
import com.voyatek.tripapp.ui.theme.CreateTripButtonBackgroundColor
import com.voyatek.tripapp.ui.theme.CreateTripButtonColor
import com.voyatek.tripapp.ui.theme.DialogLikeContentBoxBorderColor
import com.voyatek.tripapp.ui.theme.PlanTripImageBoxBgColor
import com.voyatek.tripapp.ui.theme.PlannedTripsDropDownParentBoxColor
import com.voyatek.tripapp.ui.theme.TextColorDarkBlue
import com.voyatek.tripapp.ui.theme.TextColorGrey
import com.voyatek.tripapp.ui.theme.TextDialogContentColor
import com.voyatek.tripapp.ui.theme.YourTripHeaderTextColor
import com.voyatek.tripapp.ui.theme.YourTripSubTextColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanTripScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    uiState: PlanTripUiState,
    uiEvent: (UiEventClass) -> Unit
){
    val context = LocalContext.current

    ///
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    
    Scaffold (
        topBar = {
            TopAppBar(
                title ={
                    Text(
                        text = "Plan a Trip",
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
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
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
    ) { padding ->

        if(uiState.bottomSheetVisibility){
            ModalBottomSheet(
                onDismissRequest = {
                    uiEvent(UiEventClass.hideBottomSheet)
                },
                sheetState = sheetState,
                containerColor = CreateTripButtonColor
            ) {

                // Main content of the ModalBottomSheet
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                    //    .fillMaxHeight(0.7f) // Limit the height of the bottom sheet
                ) {
                    // Scrollable content
                    LazyColumn(
                        modifier = Modifier
                            .weight(1f) // Take remaining space to enable scrolling
                            .fillMaxWidth()
                    ) {
                        item {
                            PlanTripBottomSheetContent(
                                closeBottomSheet = {
                                    uiEvent(UiEventClass.hideBottomSheet)
                                },
                                uiState = uiState,
                                uiEvent = uiEvent
                            )
                        }
                    }

                    // Fixed Bottom App Bar section

                        //create trip next button
                        Box (
                            modifier = modifier
                                .fillMaxWidth()
                                //.fillMaxHeight()
                                .height(62.dp)
                                .width(302.dp)
                                .padding(
                                    start = 16.dp,
                                    end = 16.dp,
//                                            top = 8.dp,
//                                            bottom = 8.dp
                                )
                                .clip(RoundedCornerShape(4.dp))
                                .border(width = 1.dp, color = DialogLikeContentBoxBorderColor)
                                .background(CreateTripButtonBackgroundColor)
                                .clickable {
                                        if (
                                            uiState.tripName.isEmpty()
                                            || uiState.tripTravelStyle.isEmpty()
                                            || uiState.tripDescription.isEmpty()
                                        ){
                                            Toast.makeText(
                                                context,
                                                "Please enter all fields above",
                                                Toast.LENGTH_SHORT
                                            ).show()


                                        }else{
                                            uiEvent(UiEventClass.showCreateTripDialogBox)

                                        }

                                }
                            ,
                            contentAlignment = Alignment.Center
                        ){
                            Text(
                                text = "Next",
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
                                fontWeight = FontWeight.W900,
                                lineHeight = 22.sp,
                                letterSpacing = (-0.5).sp
                            )

                        }

                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),

        ) {


            item {

                if(uiState.createTripDialogBoxVisibility){
                    CreateTripConfirmationDialogBox(
                        planTripUiState = uiState,
                        uiEvent = uiEvent
                    )
                }

                if(uiState.createTripLoadingDialogBoxVisibility){
                    CreateTripLoadingDialogBox(
                        planTripUiState = uiState,
                        uiEvent = uiEvent,
                        loadingText = "Creating trip",
                    )
                }
                //Initial Contents with omo image bg
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(390.dp)
                        .height(549.dp)
                        .padding(vertical = 0.dp)
                        .background(color = PlanTripImageBoxBgColor)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.plan_trip_bgn_image_svg),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 64.dp)
                    )
                    Column (

                    ){
                        Text(
                            text = "Plan Your Dream Trip in Minutes",
                            modifier = Modifier
                                // .height(26.dp)
                                // .width(253.dp)
                                .padding(
                                    horizontal = 16.dp,
                                    vertical = 26.dp
                                )
                            ,
                            color = TextColorDarkBlue,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 26.sp,
                            letterSpacing = (-0.5).sp




                        )
                        Text(
                            text = "Build, personalize, and optimize your itineraries with our trip planner. Perfect for getaways, remote workcations, and any spontaneous escapade.",
                            modifier = Modifier
                                // .height(26.dp)
                                // .width(253.dp)
                                .padding(
                                    horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                            ,
                            color = TextColorGrey,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 22.sp,
                            letterSpacing = (-0.5).sp
                        )

                        //Dialog like column to create trip

                            //Dialog like content
                            Column(
                                modifier = Modifier
                                .fillMaxWidth()
                                   //.wrapContentHeight()

                                .fillMaxHeight(0.95f)
                               .padding(
                                  start =  16.dp,
                                   end = 16.dp,
                                    top = 64.dp,
                                  // bottom = 16.dp
 //                                   horizontal = 28.dp
                                )
                                .width(334.dp)
                                .height(278.dp)

                                .clip(RoundedCornerShape(4.dp))
                                .background(CreateTripButtonColor),

                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Spacer(modifier = Modifier
                                    .height(10.dp))

                                DialogLikeComponents(
                                    icon = R.drawable.location,
                                    headerText = "Where to?",
                                    subText = if(uiState.tripLocationCity.isEmpty()) "Select City" else uiState.tripLocationCity,
                                    navigationAction = {
                                        navController.navigate(route = ScreenRoutes.WhereScreen.routes)
                                    }
                                    // modifier = Modifier.weight(1f)

                                )

                                Spacer(modifier = Modifier
                                    .height(10.dp))

                                Row(
                                    modifier = Modifier
                                      //  .fillMaxWidth()
                                        .width(302.dp)
                                    ,
                                    horizontalArrangement = Arrangement.SpaceBetween

                                ){
                                    DialogLikeComponents(
                                        icon = R.drawable.blank_calendar,
                                        headerText = "Start Date",
                                        subText = if(uiState.tripStartDate.isEmpty()) "Enter Date" else uiState.tripStartDate,
                                        modifier = Modifier.weight(1f),
                                        navigationAction = {
                                            navController.navigate(route = ScreenRoutes.DateScreen.routes)
                                        }
                                    )
                                    DialogLikeComponents(
                                        icon = R.drawable.blank_calendar,
                                        headerText = "End Date",
                                        subText = if(uiState.tripEndDate.isEmpty()) "Enter Date" else uiState.tripEndDate,
                                        modifier = Modifier.weight(1f),
                                        navigationAction = {
                                            navController.navigate(route = ScreenRoutes.DateScreen.routes)
                                        }

                                    )






                                }

                                //create trip button
                                Box (
                                    modifier = modifier
                                        //.fillMaxWidth()
                                        //.fillMaxHeight()
                                        .height(62.dp)
                                        .width(302.dp)
                                        .padding(
                                            start = 8.dp,
                                            end = 8.dp,
//                                            top = 8.dp,
//                                            bottom = 8.dp
                                        )
                                        .clip(RoundedCornerShape(4.dp))
                                        .border(width = 1.dp, color = DialogLikeContentBoxBorderColor)
                                        .background(CreateTripButtonBackgroundColor)
                                        .clickable {
                                            if (
                                                uiState.tripLocationCity.isEmpty()
                                                || uiState.tripStartDate.isEmpty()
                                                || uiState.tripEndDate.isEmpty()
                                            ){
                                                Toast.makeText(
                                                    context,
                                                    "Please enter all fields above",
                                                    Toast.LENGTH_SHORT
                                                ).show()


                                            }else{
                                                uiEvent(UiEventClass.showBottomSheet)

                                            }
                                                   }
                                    ,
                                    contentAlignment = Alignment.Center
                                ){
                                    Text(
                                        text = "Create a Trip",
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
                                        fontWeight = FontWeight.W900,
                                        lineHeight = 22.sp,
                                        letterSpacing = (-0.5).sp
                                    )

                                }

                            }



                      //  }





                    }
                }


                //You Trip Header Box and Content
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(263.dp)
                        .height(44.dp)
                        .padding(
                            start = 16.dp,
                            //  top = 720.dp
                        )
                ){
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ){
                        Text(text = "Your Trips",
                            modifier = Modifier
                                // .height(26.dp)
                                // .width(253.dp)
                                .padding(
                                    // horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                            ,
                            color = YourTripHeaderTextColor,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 24.sp,
                            letterSpacing = (-0.5).sp)

                        Text(text = "Your trip itineraries and  planned trips are placed here",
                            modifier = Modifier
                                // .height(26.dp)
                                // .width(253.dp)
                                .padding(
                                    //horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                            ,
                            color = YourTripSubTextColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500,
                            lineHeight = 20.sp,
                            letterSpacing = (-0.5).sp
                        )
                    }
                }

                //Planned trips drop down parent box

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(358.dp)
                        .height(54.dp)
                        .padding(
                            horizontal = 16.dp
                            //  top = 720.dp
                        )
                        .clip(RoundedCornerShape(4.dp))
                        .background(color = PlannedTripsDropDownParentBoxColor)

                ){
                    //Planned trips drop down box
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .width(342.dp)
                            .height(38.dp)
                            .padding(
                                all = 8.dp
                                //  top = 720.dp
                            )
                            .clip(RoundedCornerShape(4.dp))
                            .background(color = CreateTripButtonColor)
                        ,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween

                    ){
                        Text(
                            text = "Planned Trips",
                            modifier = Modifier
                                // .height(26.dp)
                                // .width(253.dp)
                                .padding(
                                    horizontal = 16.dp,
                                    //vertical = 57.dp
                                )
                            ,
                            color = TextDialogContentColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                            lineHeight = 22.sp,
                            letterSpacing = (-0.5).sp
                        )
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Drop down arrow"
                        )
                    }



                }

                //Planned Trip Cards List Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.height(1572.dp)
                        //.width(358.dp)
                        .padding(
                            horizontal = 16.dp,
                            vertical = 12.dp
                        )

                ){

                        PlannedTripCard(
                            tripImage = painterResource(id = R.drawable.trip_card_image),
                            tripFloatingLocation = "Paris",
                            tripNameDesc = "Bahamas Family Trip",
                            tripDate = "19th April 2024",
                            tripDays = "5 Days",
                        )
                        Spacer(modifier = Modifier
                            .height(10.dp))

                        PlannedTripCard(
                            tripImage = painterResource(id = R.drawable.trip_card_image),
                            tripFloatingLocation = "Paris",
                            tripNameDesc = "Bahamas Family Trip",
                            tripDate = "19th April 2024",
                            tripDays = "5 Days",
                        )

                    Spacer(modifier = Modifier
                        .height(10.dp))

                        PlannedTripCard(
                            tripImage = painterResource(id = R.drawable.trip_card_image),
                            tripFloatingLocation = "Paris",
                            tripNameDesc = "Bahamas Family Trip",
                            tripDate = "19th April 2024",
                            tripDays = "5 Days",
                        )




                }
            }





        }
    }
}

@Preview(
    showSystemUi = true,
    //device = "spec:width=1280dp,height=800dp,dpi=240"
)
@Composable
fun PlanTripScreenPreview(){
    //PlanTripScreen()
}