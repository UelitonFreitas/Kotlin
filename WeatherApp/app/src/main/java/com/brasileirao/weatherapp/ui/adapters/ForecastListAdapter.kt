package com.brasileirao.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.brasileirao.weatherapp.R
import com.brasileirao.weatherapp.domain.Forecast
import com.brasileirao.weatherapp.domain.ForecastList
import com.brasileirao.weatherapp.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by ueliton on 10/2/16.
 */

class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: ForecastListAdapter.OnItemClickListner) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent?.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindForecast(weekForecast[position])

    }

    override fun getItemCount(): Int {
        return weekForecast.size()
    }

    class ViewHolder(view: View, val itemClick: OnItemClickListner) :
            RecyclerView.ViewHolder(view) {

        private val iconView: ImageView;
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val maxMinTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            maxMinTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                maxTemperatureView.text = "$high"
                maxMinTemperatureView.text = "$low"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    interface OnItemClickListner {
        operator fun invoke(forecast: Forecast)
    }
}
