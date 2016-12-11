package com.brasileirao.weatherapp.data.dataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.brasileirao.weatherapp.ui.App
import org.jetbrains.anko.db.*

/**
 * Created by ueliton.freitas on 10/24/16.
 */
class ForescastDbHelper(ctx : Context = App.instance) : ManagedSQLiteOpenHelper(ctx,
        ForescastDbHelper.DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance by lazy {ForescastDbHelper()}
    }

    override fun onCreate(db: SQLiteDatabase) {

        db.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER
                )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(CityForecastTable.NAME, true)
        db.createTable(DayForecastTable.NAME, true)
    }

    infix fun <A, B> A.tadah(that: B) : Pair<A, B> = Pair(this, that)
}