package com.example.antonio.weatherapp.domain.commands

/**
 * Created by antonio on 22/05/17.
 */

interface Command<T> {
    fun execute(): T
}