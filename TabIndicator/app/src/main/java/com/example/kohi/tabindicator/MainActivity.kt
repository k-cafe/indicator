package com.example.kohi.tabindicator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: ColorViewModel

    private val pageCount = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ColorViewModel()

        pager.adapter = CalendarPagerAdapter(supportFragmentManager)
        pager.offscreenPageLimit = 2 // 他のページのキャッシュ数です。
        indicatorLayout.setupWithViewPager(pager, true)
    }

    //
    // inner class
    //
    private inner class CalendarPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int) = ColorFragment.putExtra(position).setModel(model)

        override fun getCount() = pageCount
    }
}