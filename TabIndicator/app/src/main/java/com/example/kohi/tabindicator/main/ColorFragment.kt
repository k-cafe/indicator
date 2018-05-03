package com.example.kohi.tabindicator.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kohi.tabindicator.R
import com.example.kohi.tabindicator.RColor
import com.example.kohi.tabindicator.RString
import kotlinx.android.synthetic.main.fragment_colors.*

class ColorFragment() : Fragment() {

    private var colorNo: Int = -1

    private lateinit var colorViewModel: ColorViewModel

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
                              savedInstanceState: Bundle?): View? = inflater.inflate(R.layout.fragment_colors, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorNameView.text = activity.getString(R.string.color_primary)
        backgroundLayout.background = activity.getDrawable(R.color.colorPrimary)

        colorViewModel.colorIdData.observe(this, Observer { bindColorId(it) })
        colorViewModel.colorNameId.observe(this, Observer { bindColorNameId(it) })
    }

    //
    // setups
    //
    fun setModel(model: ColorViewModel): ColorFragment {
        this.colorViewModel = model
        return this
    }

    private fun bindColorId(colorId: RColor?) {
        colorId ?: return

        backgroundLayout.background = activity.getDrawable(colorId)
    }

    private fun bindColorNameId(colorNameId: RString?) {
        colorNameId ?: return

        colorNameView.text = activity.getString(colorNameId)
    }
}