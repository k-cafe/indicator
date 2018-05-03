package com.example.kohi.tabindicator.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.kohi.tabindicator.R
import com.example.kohi.tabindicator.extensions.map


class ColorViewModel : ViewModel() {

    private val colorNoData = MutableLiveData<Int>()

    val colorIdData = colorNoData.map {
        when(it) {
            0 -> R.color.colorPrimary
            1 -> R.color.colorPrimaryDark
            else -> R.color.colorAccent
        }
    }

    val colorNameId = colorNoData.map {
        when(it) {
            0 -> R.string.color_primary
            1 -> R.string.color_primary_dark
            else -> R.string.color_accent
        }
    }

    fun setColorNo(colorNo: Int) {
        this.colorNoData.value = colorNo
    }

}