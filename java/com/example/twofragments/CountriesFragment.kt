package com.example.twofragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater

class CountriesFragment : Fragment(R.layout.fragment_countires){
    lateinit var callBack: FragmentActivityCallBack

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Check","onCreate")
        callBack = activity as FragmentActivityCallBack
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("Check","onCreateView")
        val numbers = mutableListOf<String>("India", "China", "America", "Africa")
        val listView =
            ListView(requireContext())
        val cAdapter = CustomArrayAdapter(numbers)
        listView.adapter = cAdapter
        listView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)
        val layout = LinearLayout(requireContext()).apply {
            addView(listView)
        }

        listView.setOnItemClickListener { parent, view, position, id ->
            val bundle = Bundle()
            bundle.putString("key_text",(view as TextView).text.toString())

            callBack.onClickFromFragment(bundle)
        }
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
    }


}