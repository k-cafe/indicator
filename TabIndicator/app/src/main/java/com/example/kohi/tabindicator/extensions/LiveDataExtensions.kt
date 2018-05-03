package com.example.kohi.tabindicator.extensions

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.example.kohi.tabindicator.Mapper


fun <T, U> LiveData<T>.map(mapper: Mapper<T, U>): LiveData<U> = Transformations.map(this, mapper)
