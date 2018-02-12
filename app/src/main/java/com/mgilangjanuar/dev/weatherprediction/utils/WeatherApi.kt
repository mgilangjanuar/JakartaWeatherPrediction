package com.mgilangjanuar.dev.weatherprediction.utils

import com.mgilangjanuar.dev.weatherprediction.modules.forecast.model.ForecastModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 * @since 2018
 */
class WeatherApi {

    private var baseUrl = Constant.BASE_URL
    private var adapter = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun create(): Service {
        val result = adapter.create<Service>(Service::class.java)
        baseUrl = Constant.BASE_URL
        adapter = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return result
    }

    interface Service {

        @GET("forecast")
        fun getForecast(@Query("q") query: String, @Query("appid") appId: String): Call<ForecastModel>
    }
}