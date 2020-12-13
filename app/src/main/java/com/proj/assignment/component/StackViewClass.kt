package com.proj.assignment.component

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.proj.assignment.base.BaseFragment
import com.proj.assignment.component.StackViewActivity.Companion.FRAGMENT_MAP

class StackViewClass(private var context: Context) {

    private var count: Int = 0
    private var fragmentMap: HashMap<String, BaseFragment> = hashMapOf()

    fun setFragmentCount(count: Int) {
        if (count in 2..4) {
            this.count = count
        } else {
            showToast()
        }
    }

    fun createView(fragment1: BaseFragment, fragment2: BaseFragment) {
        if (count == 2) {
            fragmentMap.clear()
            fragmentMap[StackViewActivity.FIRST_TAG] = fragment1
            fragmentMap[StackViewActivity.SECOND_TAG] = fragment2
            startActivity()
        } else {
            showToast()
        }
    }

    fun createView(fragment1: BaseFragment, fragment2: BaseFragment, fragment3: BaseFragment) {
        if (count == 3) {
            fragmentMap.clear()
            fragmentMap[StackViewActivity.FIRST_TAG] = fragment1
            fragmentMap[StackViewActivity.SECOND_TAG] = fragment2
            fragmentMap[StackViewActivity.THIRD_TAG] = fragment3
            startActivity()
        } else {
            showToast()
        }
    }

    fun createView(
        fragment1: BaseFragment,
        fragment2: BaseFragment,
        fragment3: BaseFragment,
        fragment4: BaseFragment
    ) {
        if (count == 4) {
            fragmentMap.clear()
            fragmentMap[StackViewActivity.FIRST_TAG] = fragment1
            fragmentMap[StackViewActivity.SECOND_TAG] = fragment2
            fragmentMap[StackViewActivity.THIRD_TAG] = fragment3
            fragmentMap[StackViewActivity.FOURTH_TAG] = fragment4
            startActivity()
        } else {
            showToast()
        }
    }

    private fun showToast() {
        Toast.makeText(context, "Invalid Views", Toast.LENGTH_SHORT).show()
    }

    private fun startActivity() {
        if (count > 1 && fragmentMap.isNotEmpty()) {
            val intent = Intent(context, StackViewActivity::class.java)
            intent.putExtra(FRAGMENT_MAP, fragmentMap)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            context.startActivity(intent)
        }
    }

}