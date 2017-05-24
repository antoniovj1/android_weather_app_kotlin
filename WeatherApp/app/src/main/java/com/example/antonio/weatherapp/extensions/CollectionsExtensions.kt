package com.example.antonio.weatherapp.extensions

/**
 * Created by antonio on 24/05/17.
 */


fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()
