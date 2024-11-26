package com.voyatek.tripapp.features.trips.domain.model

data class GetTripModel (
    val tripLocationCity: String,
    val tripStartDate: String,
    val tripEndDate: String,
    val tripName: String,
    val tripTravelStyle: String,
    val tripDescription: String,
    )
//
//[{
//    "status": 1,
//    "success": true,
//    "title": "Zanzibar Hangout",
//    "location": "Tanzania"
//    "start_date": "20 Nov, 2024",
//    "end_date": "28 Nov, 2024",
//    "completed": true
//},
//{
//    "status": 1,
//    "success": true,
//    "title": "Lekki hangout",
//    "location": "Lagos"
//    "start_date": "20 Nov, 2024",
//    "end_date": "28 Nov, 2024",
//    "completed": true
//}
//]