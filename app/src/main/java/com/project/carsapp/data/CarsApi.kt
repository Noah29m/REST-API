package com.project.carsapp.data

import retrofit2.http.GET

interface CarsApi {
    @GET("/randomcar")

    suspend fun getRandomCar(): Car

    companion object {
        const val BASE_URL ="http://192.168.0.102:8080"
    }
}