package com.example.twofragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class CountryDetailsFragment : Fragment(R.layout.country_details) {
    lateinit var textView : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        textView = TextView(requireContext()).apply {
            text = "text"
        }
        return LinearLayout(requireContext()).apply {
            addView(textView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView.text = arguments?.getString("key_text","")

    }
}