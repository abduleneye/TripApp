package com.voyatek.tripapp.features.trips.data.remote

import com.voyatek.tripapp.features.trips.domain.model.CreateTripBodyModel
import com.voyatek.tripapp.features.trips.domain.model.CreateTripResponseModel
import com.voyatek.tripapp.features.trips.domain.model.GetTripModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface TripApi {
    @GET("/get_trips")
    suspend fun getTrips(): Response<List<GetTripModel>>

    @POST("/create_trip")
    suspend fun postTrip(@Body trip: CreateTripBodyModel): Response<CreateTripResponseModel>

    companion object {
        val BASE_URL = "https://trips.free.beeceptor.com"
        //val okHttpClient = OkHttpClient
//            .Builder()
//            .addInterceptor(ErrorInterceptor())
//            .build()
    }
}