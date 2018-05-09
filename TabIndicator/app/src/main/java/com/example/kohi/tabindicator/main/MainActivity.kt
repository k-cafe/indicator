package com.example.kohi.tabindicator.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
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

        initializePageViewer()
        initializeIndicator()
    }

    //
    // setUps
    //

    private fun initializePageViewer() {
        pagerView.adapter = ColorPagerAdapter(supportFragmentManager)
        pagerView.offscreenPageLimit = 2
        pagerView.addOnPageChangeListener(pageChangeListener)
    }

    private fun initializeIndicator() {
        indicatorLayout.setupWithViewPager(pagerView, true)
        for (tabNo in 0..pageCount) {
            indicatorLayout.getTabAt(tabNo)?.icon = ContextCompat.getDrawable(this, R.drawable.selector_indicator)
        }
    }

    private val pageChangeListener = object : ViewPager.SimpleOnPageChangeListener() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            colorViewModel.setColorNo(position)
        }
    }

    //
    // inner class
    //

    private inner class ColorPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int) = ColorFragment.putExtra(position).setModel(colorViewModel)

        override fun getCount() = pageCount
    }
}
