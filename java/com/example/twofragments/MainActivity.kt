package com.example.twofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import androidx.activity.addCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.fragment.app.FragmentContainerView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class MainActivity : AppCompatActivity() , FragmentActivityCallBack {

    val fragmentManger = supportFragmentManager
    var countryName : String? =  null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(findViewById<ConstraintLayout>(R.id.portrait) != null) {
            if(savedInstanceState == null) {
                addFragment()
            }
            if(savedInstanceState?.getString("key_text") != null){
                addFragmentDetails(Bundle().apply {
                    putString("key_text", savedInstanceState.getString("key_text"))
                })
            }
        }
        if(findViewById<ConstraintLayout>(R.id.landscape) != null) {
            addFragment()
            if(savedInstanceState == null) {
                addFragmentDetails(Bundle().apply {
                    putString("key_text","India")
                })
            }else{
                addFragmentDetails(Bundle().apply {
                    putString("key_text",savedInstanceState.getString("key_text","India"))
                })
            }

        }


        onBackPressedDispatcher.addCallback(this) {
            if(fragmentManger.backStackEntryCount > 0){
                fragmentManger.popBackStack()
            }else{
                finish()
            }
        }
    }


    fun addFragment(){
        val fragmentTransaction = fragmentManger.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView1,CountriesFragment())
        fragmentTransaction.commit()
    }

    fun addFragmentDetails(bundle: Bundle){
        val fragmentTransaction = fragmentManger.beginTransaction()
        if (findViewById<ConstraintLayout>(R.id.portrait) !=null) {
            fragmentTransaction.replace(
                R.id.fragmentContainerView1,
                CountryDetailsFragment().apply {
                    arguments = bundle
                })
        }
        if (findViewById<ConstraintLayout>(R.id.landscape) !=null) {
            fragmentTransaction.replace(
                R.id.fragmentContainerView,
                CountryDetailsFragment().apply {
                    arguments = bundle
                })
        }
        fragmentTransaction.addToBackStack("second")
        fragmentTransaction.commit()
    }




    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if(countryName != null) {
            outState.putString("key_text", countryName)

        }
        Log.i("TAG","Save $countryName")
    }



    override fun onClickFromFragment(bundle: Bundle) {
        this.countryName = bundle.getString("key_text")
        Log.i("TAG","countryName $countryName ")
        addFragmentDetails(bundle)
    }
}



