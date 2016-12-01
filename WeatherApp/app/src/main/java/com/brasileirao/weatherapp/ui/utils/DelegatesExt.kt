package com.brasileirao.weatherapp.ui.utils

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by ueliton.freitas on 10/24/16.
 */
object DelegatesExt {
    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSigleValueVar()
}

private class NotNullSigleValueVar<T>() : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalAccessException("${property.name} " + "not initialized")
    }


    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value
        else throw IllegalAccessException("${property.name} already initialized")
    }

}