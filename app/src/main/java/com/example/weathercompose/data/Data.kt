package com.example.weathercompose.data

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


fun getData(city: String, context: Context, daysList: MutableState<List<WeatherModel>>) {

    val url="https://api.weatherapi.com/v1/forecast.json"+
            "?key=$API_KEY&"+
            "q=$city"+
            "&days="+
            "3"+
            "&aqi=no&alerts=no"
    val queue = Volley.newRequestQueue(context)
    val sRequest = StringRequest(
        Request.Method.GET,
        url,
        {
            response ->
            val list = getWeatherByDays(response)
            daysList.value = list
            Log.d("Mylog", "Response: $response")
        },
        {
            Log.d("MyLog","VolleyError: $it")
        }
    )
    queue.add(sRequest)
}
