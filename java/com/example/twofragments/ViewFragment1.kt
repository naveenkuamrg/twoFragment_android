package com.example.twofragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment

class ViewFragment1 : Fragment() {
    var ids : Int
    companion object {
        var counter = 0
    }
    init {
        ids = counter
        Log.i("TAGCHECK","Fragment is init + $ids")
        counter++
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ConstraintLayout(requireContext()).apply {
            addView(TextView(requireContext()).apply {
                text = "ViewFragment1 + $ids"
                gravity = Gravity.CENTER
            })
            id = R.id.textView1
            setBackgroundColor(Color.CYAN)
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAGCHECK","onDestroy + $ids")
    }

}