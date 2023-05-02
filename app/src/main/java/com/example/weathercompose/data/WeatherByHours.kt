package com.example.weathercompose.compose

import androidx.compose.runtime.Composable
import com.example.weathercompose.data.WeatherModel
import org.json.JSONArray
import org.json.JSONObject


fun getWeatherByHours(hours:String ): List<WeatherModel> {
    if(hours.isEmpty())return listOf()
    val hoursArray = JSONArray(hours)

    val list = ArrayList<WeatherModel>()
    for (i in 0 until hoursArray.length()){
        val item = hoursArray[i] as JSONObject
        list.add(
            WeatherModel(
                "",
                item.getString("time"),
                item.getString("temp_c").toFloat().toInt().toString() + "C",
                item.getJSONObject("condition").getString("text"),
                item.getJSONObject("condition").getString("icon"),
                "10.0",
                "10.0",
                "",
                item.getString("wind_kph").toFloat().toInt().toString()+ "km/h",
                item.getString("wind_dir")
            )
        )
    }
    return list

}