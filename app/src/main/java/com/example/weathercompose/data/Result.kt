package com.example.weathercompose.data

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


fun getResult(city: String, state: MutableState<String>, context : Context){
    val url = "http://api.weatherapi.com/v1/current.json"+
        "?key=$API_KEY&"+
        "q=$city"+
        "&aqi=no"

    val queue = Volley.newRequestQueue(context)
    val stringRequest = StringRequest(
        Request.Method.GET,
        url,
        {
            response ->
            val obj = JSONObject(response)
            state.value = obj.getJSONObject("current").getString("temp_c")
        },
        {
            error->
            Log.d("MyLog", "Error $error")
        }
    )
    queue.add(stringRequest)

}