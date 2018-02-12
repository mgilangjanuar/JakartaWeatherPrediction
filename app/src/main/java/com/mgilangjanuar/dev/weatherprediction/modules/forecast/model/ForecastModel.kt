package com.mgilangjanuar.dev.weatherprediction.modules.forecast.model

import com.google.gson.annotations.SerializedName

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 * @since 2018
 */
class ForecastModel {

    var cod: String = ""
    var message: Double = 0.0
    var cnt: Int = 0
    var city: City = City()
    var list: List<ForecastDetail> = ArrayList()

    class City {
        var id: Int = 0
        var name: String = ""
        var country: String = ""
        var population: Long = 0
        var coord: Coord = Coord()

        class Coord {
            var lat: Double = 0.0
            var lon: Double = 0.0
        }
    }

    class ForecastDetail {
        var dt: Long = 0
        @SerializedName("dt_txt")
        var dtTxt: String = ""
        var main: MainData = MainData()
        var weather: List<Weather> = ArrayList()
        var clouds: Cloud = Cloud()
        var wind: Wind = Wind()
        var rain: Rain = Rain()


        class MainData {
            var temp: Double = 0.0
            @SerializedName("tmp_min")
            var tempMin: Double = 0.0
            @SerializedName("tmp_max")
            var tempMax: Double = 0.0
            var pressure: Double = 0.0
            @SerializedName("sea_level")
            var seaLevel: Double = 0.0
            @SerializedName("grnd_level")
            var grndLevel: Double = 0.0
            var humidity: Int = 0
            @SerializedName("temp_kf")
            var tempKf: Double = 0.0
        }

        class Weather {
            var id: Int = 0
            var main: String = ""
            var description: String = ""
            var icon: String = ""
        }

        class Cloud {
            var all: Int = 0
        }

        class Wind {
            var speed: Double = 0.0
            var deg: Double = 0.0
        }

        class Rain {
            @SerializedName("3h")
            var percent: Double = 0.0
        }
    }

}