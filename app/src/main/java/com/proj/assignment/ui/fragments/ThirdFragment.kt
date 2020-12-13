package com.proj.assignment.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proj.assignment.R
import com.proj.assignment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_third.*

class ThirdFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onStart() {
        super.onStart()
        tvNext.setOnClickListener {
            openNext()
        }

        text.setOnClickListener {
            showCurrent()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): ThirdFragment {
            return ThirdFragment()
        }
    }
}