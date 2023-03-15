package com.project.carsapp.carsapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.project.carsapp.data.Car
import com.project.carsapp.data.CarsApi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(
    private val api: CarsApi


) : ViewModel() {
    private val _state = mutableStateOf<CarState>()
    val : State<CarState> = _state

    data class CarState(
        val car: Car? = null,
        val isLoading: Boolean =false

    )

}