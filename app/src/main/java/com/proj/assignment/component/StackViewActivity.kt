package com.proj.assignment.component

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proj.assignment.R
import com.proj.assignment.base.BaseFragment

@Suppress("UNCHECKED_CAST")
class StackViewActivity : AppCompatActivity(), BaseFragment.FragmentInteractionListener {

    companion object {
        //Fragment Tags
        const val FIRST_TAG = "FIRST_TAG"
        const val SECOND_TAG = "SECOND_TAG"
        const val THIRD_TAG = "THIRD_TAG"
        const val FOURTH_TAG = "FOURTH_TAG"
        const val FRAGMENT_MAP = "FRAGMENT_MAP"
    }

    private var fragmentMap: HashMap<String, BaseFragment>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack_view)

        fragmentMap = intent.getSerializableExtra(FRAGMENT_MAP) as? HashMap<String, BaseFragment>

        //set first fragment
        val frag1 = fragmentMap?.get(FIRST_TAG)
        frag1?.let {
            it.setTags(
                FIRST_TAG,
                SECOND_TAG
            )
            supportFragmentManager.beginTransaction().add(
                R.id.firstContainer, it,
                FIRST_TAG
            )
                .addToBackStack(FIRST_TAG)
                .commit()
        }

    }

    override fun onFragmentClicked(currentTag: String?, nextTag: String?) {
        val frag = fragmentMap?.get(nextTag)
        frag?.let {
            it.setTags(nextTag!!, openTag(nextTag))
            supportFragmentManager.beginTransaction()
                .add(findContainer(nextTag), it, nextTag)
                .addToBackStack(nextTag)
                .commit()
        }

    }

    override fun showFragment(currentTag: String?) {
        val currentFragment = supportFragmentManager.findFragmentByTag(currentTag)
        currentFragment?.let {
            supportFragmentManager.popBackStack(currentTag, 0)
        }
    }

    private fun findContainer(tag: String): Int {
        var container = 0
        when (tag) {
            FIRST_TAG -> container = R.id.firstContainer
            SECOND_TAG -> container = R.id.secondContainer
            THIRD_TAG -> container = R.id.thirdContainer
            FOURTH_TAG -> container = R.id.fourthContainer
        }

        return container
    }

    private fun openTag(currentTag: String): String {
        var nextTag = ""
        when (currentTag) {
            FIRST_TAG -> nextTag =
                SECOND_TAG
            SECOND_TAG -> nextTag =
                THIRD_TAG
            THIRD_TAG -> nextTag =
                FOURTH_TAG
        }
        return nextTag
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}