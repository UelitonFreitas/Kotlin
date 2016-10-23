package com.brasileirao.weatherapp.domain.commands

/**
 * Created by ueliton on 10/4/16.
 */
public interface Command<T> {
    fun execute(): T
}