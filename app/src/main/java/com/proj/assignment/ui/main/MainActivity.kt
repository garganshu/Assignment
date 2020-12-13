package com.proj.assignment.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proj.assignment.R
import com.proj.assignment.component.StackViewClass
import com.proj.assignment.ui.fragments.FirstFragment
import com.proj.assignment.ui.fragments.FourthFragment
import com.proj.assignment.ui.fragments.SecondFragment
import com.proj.assignment.ui.fragments.ThirdFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            initializeView()
        }
    }

    private fun initializeView() {
        val stackView = StackViewClass(this)
        stackView.setFragmentCount(4)
        val firstFragment = FirstFragment.newInstance()
        val secondFragment = SecondFragment.newInstance()
        val thirdFragment = ThirdFragment.newInstance()
        val fourthFragment = FourthFragment.newInstance()
        stackView.createView(
            fragment1 = firstFragment,
            fragment2 = secondFragment,
            fragment3 = thirdFragment,
            fragment4 = fourthFragment
        )

    }
}