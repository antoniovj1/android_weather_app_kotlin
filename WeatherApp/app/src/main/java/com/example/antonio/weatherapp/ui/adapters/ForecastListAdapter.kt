package com.example.antonio.weatherapp.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.antonio.weatherapp.R
import com.example.antonio.weatherapp.domain.model.Forecast
import com.example.antonio.weatherapp.domain.model.ForecastList
import com.example.antonio.weatherapp.extensions.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import kotlinx.android.synthetic.main.item_forecast.view.*
import java.text.DateFormat
import java.util.*

/**
 * Created by antonio on 22/05/17.
 */

class ForecastListAdapter(val weekForecast: ForecastList, val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icon)
                itemView.date.text = convertDate(date)
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }

        private fun convertDate(date: Long): String {
            val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
            return df.format(date)
        }
    }
}