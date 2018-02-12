package com.mgilangjanuar.dev.weatherprediction.modules.forecast.presenter

import com.mgilangjanuar.dev.weatherprediction.modules.forecast.model.ForecastModel
import com.mgilangjanuar.dev.weatherprediction.modules.forecast.view.adapter.ForecastAdapter
import com.mgilangjanuar.dev.weatherprediction.utils.Constant
import com.mgilangjanuar.dev.weatherprediction.utils.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 * @since 2018
 */
class ForecastPresenter(val listener: ForecastPresenterListener) {

    fun retrieveData() {
        WeatherApi().create().getForecast(Constant.CITY_QUERY, Constant.APP_ID).enqueue(object : Callback<ForecastModel> {
            override fun onFailure(call: Call<ForecastModel>?, t: Throwable?) {
                listener.onError(t!!.message!!)
            }

            override fun onResponse(call: Call<ForecastModel>?, response: Response<ForecastModel>?) {
                listener.onSucceed(ForecastAdapter(response!!.body()!!.list))
            }

        })
    }

    interface ForecastPresenterListener {
        fun onError(message: String)
        fun onSucceed(adapter: ForecastAdapter)
    }
}