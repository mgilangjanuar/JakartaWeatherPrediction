package com.mgilangjanuar.dev.weatherprediction.modules.forecast.view.activity

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.mgilangjanuar.dev.weatherprediction.R
import com.mgilangjanuar.dev.weatherprediction.base.BaseActivity
import com.mgilangjanuar.dev.weatherprediction.modules.forecast.presenter.ForecastPresenter
import com.mgilangjanuar.dev.weatherprediction.modules.forecast.view.adapter.ForecastAdapter
import kotterknife.bindView

class ForecastActivity : BaseActivity(), ForecastPresenter.ForecastPresenterListener {

    private val recyclerView: RecyclerView by bindView(R.id.forecast)
    private val presenter: ForecastPresenter = ForecastPresenter(this)

    override fun findLayout(): Int {
        return R.layout.activity_forecast
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView(recyclerView, false)
        presenter.retrieveData()
    }

    override fun onError(message: String) {
        showSnackbar(message)
    }

    override fun onSucceed(adapter: ForecastAdapter) {
        recyclerView.adapter = adapter
    }
}
