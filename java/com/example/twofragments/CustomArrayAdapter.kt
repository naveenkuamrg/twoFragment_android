package com.example.twofragments

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomArrayAdapter(val numbers : List<String>) : BaseAdapter() {
    override fun getCount(): Int {
        return  numbers.count()
    }

    override fun getItem(position: Int): String {
        return  numbers[position]
    }

    override fun getItemId(position: Int): Long {

        return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        Log.i("SoutId",getItemId(position).toString())
        return TextView(parent.context).apply {
            text = getItem(position)
            id = R.id.textView
        }
    }




}