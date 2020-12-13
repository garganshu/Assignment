package com.proj.assignment.base

import android.content.Context
import androidx.fragment.app.Fragment
import java.io.Serializable

open class BaseFragment : Fragment(), Serializable {

    interface FragmentInteractionListener {
        fun onFragmentClicked(currentTag: String?, nextTag: String?)
        fun showFragment(currentTag: String?)
    }

    private var currentTag: String? = null
    private var nextTag: String? = null
    private var listener: FragmentInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(
                context.toString()
                        + " must implement OnFragmentInteractionListener"
            )
        }
    }

    private fun getListener(): FragmentInteractionListener? {
        return listener
    }

    fun openNext() {
        getListener()?.onFragmentClicked(getCurrentTag(), getNextTag())
    }

    fun showCurrent() {
        getListener()?.showFragment(getCurrentTag())
    }

    fun setTags(currentTag: String, nextTag: String) {
        this.currentTag = currentTag
        this.nextTag = nextTag
    }

    private fun getCurrentTag(): String? {
        return currentTag
    }

    private fun getNextTag(): String? {
        return nextTag
    }

}