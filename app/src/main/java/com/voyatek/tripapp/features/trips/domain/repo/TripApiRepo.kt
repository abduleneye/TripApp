package com.voyatek.tripapp.features.trips.domain.repo

import com.voyatek.tripapp.features.trips.core.utils.Resource
import com.voyatek.tripapp.features.trips.domain.model.CreateTripBodyModel
import com.voyatek.tripapp.features.trips.domain.model.CreateTripResponseModel
import com.voyatek.tripapp.features.trips.domain.model.TripModel
import kotlinx.coroutines.flow.Flow

interface TripApiRepo {

        fun createTrip(createTrip: CreateTripBodyModel): Flow<Resource<CreateTripResponseModel>>

        fun viewTrip() : Flow<Resource<TripModel>>

}