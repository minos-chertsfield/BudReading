package com.minos.budreading.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.minos.budreading.R
import com.minos.budreading.model.InfoModel

class InfoAdapter(private val context: Context) : BaseAdapter() {

    private val inflater = LayoutInflater.from(context)

    private val infoList = mutableListOf<InfoModel>()
    override fun getCount(): Int {
        return infoList.size
    }

    override fun getItem(position: Int): InfoModel {
        return infoList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view = inflater.inflate(R.layout.item_layout_type_one_col, null)
        val model = infoList[position]
        val tvTitle = view.findViewById<TextView>(R.id.tv_title)
        tvTitle.text = model.title
        return view
    }

    fun setData(dataList: List<InfoModel>) {
        infoList.clear()
        infoList.addAll(dataList)
        notifyDataSetChanged()
    }
}