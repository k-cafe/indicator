package com.example.kohi.tabindicator

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_colors.*

class ColorFragment() : Fragment() {

    private var colorNo: Int = -1

    private lateinit var model: ColorViewModel

    companion object {
        fun putExtra(colorNo: Int) = ColorFragment().apply {
            arguments = Bundle().apply {
                putInt("colorNo", colorNo)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val arg = arguments ?: return
        colorNo = arg.getInt("colorNo")
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.fragment_colors, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    //
    // setups
    //
    fun setModel(model: ColorViewModel) : ColorFragment {
        this.model = model
        return this
    }
}