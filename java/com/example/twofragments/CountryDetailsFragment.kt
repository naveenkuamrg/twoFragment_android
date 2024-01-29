package com.example.twofragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.addCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.SharedElementCallback
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.transition.TransitionInflater
import kotlin.math.log

class CountryDetailsFragment : Fragment(R.layout.country_details){

    var numCounter = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
        enterTransition = inflater.inflateTransition(R.transition.slide_right)



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(parentFragmentManager === requireActivity().supportFragmentManager){
            Log.i("TAGL","True")
        }else{
            Log.i("TAGL","False")
        }

        return super.onCreateView(inflater, container, savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.textView).text = arguments?.getString("key_text","")
        view.findViewById<Button>(R.id.bt1).setOnClickListener {
            addViewFragment()
        }


        view.findViewById<Button>(R.id.back).setOnClickListener {
            if(childFragmentManager.backStackEntryCount > 0 ){
                childFragmentManager.popBackStack()
            }
        }



    }

    fun addViewFragment(){

        /*
        if you choose the parentFragmentManager Activity it life or Extends to another Fragment too
        so use childFragmentManger to Life different Fragment
         */
        val transition =  childFragmentManager.beginTransaction()
        if(numCounter == 1){
        transition.replace(R.id.fragmentContainerView23,ViewFragment1().apply {
            Log.i("Id",id.toString())
        })}
        if(numCounter == 2)
        transition.replace(R.id.fragmentContainerView2,ViewFragment1())
        if(numCounter == 3)
        transition.replace(R.id.fragment_container_view_tag3,ViewFragment1())
        if(numCounter == 4)
        transition.replace(R.id.fragment_container_view_tag4,ViewFragment1())
        transition.addToBackStack("Add")
        transition.commit()
        numCounter += 1
    }

    override fun onStart() {
        super.onStart()
        Log.i("Check","onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Check","onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Check","onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Check","onDestroy Fragments")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Check","onStop")
    }




}