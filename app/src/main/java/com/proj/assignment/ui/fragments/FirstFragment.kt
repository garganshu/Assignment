package com.proj.assignment.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proj.assignment.R
import com.proj.assignment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : BaseFragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
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
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }
}