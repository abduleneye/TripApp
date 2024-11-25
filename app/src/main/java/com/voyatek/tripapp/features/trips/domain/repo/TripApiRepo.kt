package com.voyatek.tripapp.features.trips.domain.repo

import com.voyatek.tripapp.features.trips.core.utils.Resource
import com.voyatek.tripapp.features.trips.domain.model.TripModel
import kotlinx.coroutines.flow.Flow

interface TripApiRepo {

       // fun createTrip(createTrip: TripModel): Flow<Resource<TripModel>>

        fun viewTrip() : Flow<Resource<TripModel>>

}