package com.example.weathercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.weathercompose.compose.DialogSearh
import com.example.weathercompose.compose.MainCard
import com.example.weathercompose.compose.TabLayout
import com.example.weathercompose.data.WeatherModel
import com.example.weathercompose.data.getData
import com.example.weathercompose.ui.theme.WeatherComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherComposeTheme {
                val daysList = remember{
                    mutableStateOf(listOf<WeatherModel>())
                }
                val dialogState = remember{
                    mutableStateOf( false)
                }
                val currentDay =remember{
                    mutableStateOf(WeatherModel(
                        "",
                        "",
                        "10.0",
                        "",
                        "",
                        "10.0",
                        "10.0",
                        "",
                        "",
                        ""
                    ))
                }
                if(dialogState.value){
                    DialogSearh(dialogState, onSubmit = {
                        getData(it, this, daysList, currentDay)
                    })
                }
                getData("Brest", this, daysList, currentDay)
                Image(
                    painter = painterResource(
                        id = R.drawable.weather_bg
                    ),
                    contentDescription = "img1",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.5f),
                    contentScale = ContentScale.FillBounds
                )
                // A surface container using the 'background' color from the theme
                Column() {
                    MainCard(currentDay, onClickSync = {
                        getData("Brest", this@MainActivity, daysList, currentDay)
                    }, onClickSearh = {
                        dialogState.value = true
                    }
                    )
                    TabLayout(daysList,currentDay)
                }
            }
        }
    }
}
