package com.voyatek.tripapp.features.trips.core.di

import android.app.Application
import com.voyatek.tripapp.features.trips.data.remote.TripApi
import com.voyatek.tripapp.features.trips.data.remote.repo.TripApiRepoApiImplementation
import com.voyatek.tripapp.features.trips.domain.repo.TripApiRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesTripRepo(): TripApi{
        return Retrofit
            .Builder()
            .baseUrl(TripApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TripApi::class.java)
    }

    @Provides
    @Singleton
    fun providesTripApiRepo(tripApi: TripApi, app: Application): TripApiRepo {
        return TripApiRepoApiImplementation(tripApi = tripApi)
    }
}