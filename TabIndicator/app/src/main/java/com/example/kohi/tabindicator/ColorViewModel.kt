package com.example.kohi.tabindicator

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel


class ColorViewModel : ViewModel() {

    private val colorNoData = MutableLiveData<Int>()

    fun setColorNo(colorNo: Int) {
        this.colorNoData.value = colorNo
    }

}