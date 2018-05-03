package com.example.kohi.tabindicator.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.example.kohi.tabindicator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var colorViewModel: ColorViewModel

    private val pageCount = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorViewModel = ColorViewModel()

        pagerView.adapter = CalendarPagerAdapter(supportFragmentManager)
        pagerView.offscreenPageLimit = 2 
        pagerView.addOnPageChangeListener(pageChangeListener)
        indicatorLayout.setupWithViewPager(pagerView, true)
    }

    //
    // setUps
    //
    private val pageChangeListener = object : ViewPager.SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            colorViewModel.setColorNo(position)
        }
    }

    //
    // inner class
    //
    private inner class CalendarPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int) = ColorFragment.putExtra(position).setModel(colorViewModel)

        override fun getCount() = pageCount
    }
}