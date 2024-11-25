package com.voyatek.tripapp.features.trips.data.remote

import com.voyatek.tripapp.features.trips.domain.model.TripModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface TripApi {
    @GET("/get_trips")
    suspend fun getTrips(): Response<TripModel>

    companion object {
        val BASE_URL = "https://trips.free.beeceptor.com"
        //val okHttpClient = OkHttpClient
//            .Builder()
//            .addInterceptor(ErrorInterceptor())
//            .build()
    }
}