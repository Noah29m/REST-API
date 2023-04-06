package com.project.carsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

import com.project.carsapp.carsapp.MainViewModel
import com.project.carsapp.ui.theme.CarsappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalCoilApi
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarsappTheme {
                Column(modifier =
                Modifier
                    .fillMaxSize()
                    .padding(32.dp)

                ) {
                    val viewModel: MainViewModel = hiltViewModel()
                    val car = viewModel.state.value.car
                    var isLoading = viewModel.state.value.isLoading
                    car?.let {
                        Image(painter = rememberImagePainter(data = car.imageUrl,
                            builder = {
                                crossfade(true)
                            }

                            ), contentDescription = "car")
                        Spacer(modifier = Modifier.height(8.dp))
                     androidx.compose.material.Text(text = car.name,
                         fontWeight = FontWeight.Bold,
                         fontSize = 24.sp


                         )
                        Spacer(modifier = Modifier.height(8.dp))
                        androidx.compose.material.Text(text = car.description)
                        Spacer(modifier = Modifier.height(8.dp))

                    }
                    Button(onClick = viewModel::getRandomCar,
                        modifier = Modifier.align(Alignment.End)

                    ) {
                        androidx.compose.material.Text(text = "Next Car")
                        Spacer(modifier = Modifier.height(8.dp))
                        if (isLoading){
                            CircularProgressIndicator()
                        }


                    }

                }

            }
        }
    }
}

