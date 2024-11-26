package com.voyatek.tripapp.features.trips.data.remote.repo

import com.voyatek.tripapp.features.trips.core.utils.Resource
import com.voyatek.tripapp.features.trips.data.remote.TripApi
import com.voyatek.tripapp.features.trips.domain.model.CreateTripBodyModel
import com.voyatek.tripapp.features.trips.domain.model.CreateTripResponseModel
import com.voyatek.tripapp.features.trips.domain.model.GetTripModel
import com.voyatek.tripapp.features.trips.domain.repo.TripApiRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class TripApiRepoApiImplementation(
    private val tripApi: TripApi
): TripApiRepo {
    override fun createTrip(createTrip: CreateTripBodyModel): Flow<Resource<CreateTripResponseModel>> = flow{
        emit(Resource.Loading(
        ))

        try {
            val result = tripApi.postTrip(trip = createTrip)
            emit(Resource.Success(
                data = result.body()
            ))

        }catch (e: HttpException){
            emit(
                Resource.Error(
                    message = e.message,
                    data = null
                )
            )

        }catch (e: IOException){
            emit(
                Resource.Error(
                    message = e.message,
                    data = null
                )
            )

        }
    }

    override fun viewTrip(): Flow<Resource<List<GetTripModel>>>  = flow {

        emit(
            Resource.Loading(

            )
        )

        try{

            val result = tripApi.getTrips()
            emit(
                Resource.Success(
                    data = result.body()
                )
            )

        }catch (e: HttpException){
            emit(
                Resource.Error(
                    message = e.message,
                    data = null
                )
            )

        }catch (e: IOException){
            emit(
                Resource.Error(
                    message = e.message,
                    data = null
                )
            )

        }
    }

//    override fun viewTrip(): Flow<Resource<GetTripModel>> {
//        TODO("Not yet implemented")
//    }
}