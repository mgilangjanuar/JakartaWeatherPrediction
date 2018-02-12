package com.mgilangjanuar.dev.weatherprediction.modules.forecast.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mgilangjanuar.dev.weatherprediction.R
import com.mgilangjanuar.dev.weatherprediction.modules.forecast.model.ForecastModel
import com.mgilangjanuar.dev.weatherprediction.utils.Constant
import kotterknife.bindView

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 * @since 2018
 */
class ForecastAdapter(): RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    var list: List<ForecastModel.ForecastDetail> = ArrayList()

    constructor(list: List<ForecastModel.ForecastDetail>) : this() {
        this.list = list
    }

    override fun onBindViewHolder(holder: ForecastViewHolder?, position: Int) {
        val model = list.get(position)
        holder!!.date.setText(model.dtTxt)
        holder.title.setText(model.weather.get(0).main)
        holder.description.setText(model.weather.get(0).description)
        Glide.with(holder.itemView.context).load(Constant.ICON_BASE_URL + model.weather.get(0).icon + Constant.ICON_EXTENSION).into(holder.icon)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.layout_weather, parent, false))
    }

    class ForecastViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val date: TextView by bindView(R.id.date)
        val title: TextView by bindView(R.id.title)
        val description: TextView by bindView(R.id.description)
        val icon: ImageView by bindView(R.id.icon)
    }
}