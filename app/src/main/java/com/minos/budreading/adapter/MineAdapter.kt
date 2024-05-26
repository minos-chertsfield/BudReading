package com.minos.budreading.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.imageview.ShapeableImageView
import com.minos.budreading.model.CardBean
import com.minos.budreading.R
import com.minos.budreading.ViewUtil
import com.minos.budreading.model.InfoModel

class MineAdapter(private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private val mDataList = mutableListOf<CardBean>()
    companion object {
        private const val VIEW_TYPE_ONE_COL = 1
        private const val VIEW_TYPE_TWO_COL = 2
        private const val VIEW_TYPE_INFO = 3
    }

    fun setData(dataList: MutableList<CardBean>) {
        mDataList.clear()
        mDataList.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when(mDataList[position].type) {
             1 -> VIEW_TYPE_ONE_COL
             2 -> VIEW_TYPE_TWO_COL
             else -> VIEW_TYPE_INFO
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            VIEW_TYPE_ONE_COL -> ViewHolderOneCol(inflater.inflate(R.layout.layout_type_one_col, parent, false))
            VIEW_TYPE_TWO_COL -> ViewHolderTwoCol(inflater.inflate(R.layout.layout_type_two_col, parent, false))
            else -> ViewHolderInfo(inflater.inflate(R.layout.layout_type_info, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = mDataList[position]
        when(holder) {
            is ViewHolderOneCol -> {
                val adapter = InfoAdapter(context)
                holder.listView.adapter = adapter
                adapter.setData(model.item1?.list ?: mutableListOf())
                holder.listView.layoutParams.height = ViewUtil.dp2px(66f + 8f) * (model.item1?.list?.size ?: 0)
            }
            is ViewHolderTwoCol -> {
                holder.apply {
                    item1.apply {
                        findViewById<TextView>(R.id.tv_state).text = "在读"
                    }
                    item2.apply {
                        findViewById<TextView>(R.id.tv_state).text = "读完"
                    }
                    item3.apply {
                        findViewById<TextView>(R.id.tv_state).text = "笔记"
                    }
                    item4.apply {
                        findViewById<TextView>(R.id.tv_state).text = "订阅"
                    }
                }
            }
            is ViewHolderInfo -> {
                holder.apply {
                    tvName.text = model.item3?.name
                    tvSignature.text = model.item3?.signature
                }
            }
        }
    }

}

/**
 * 列表布局
 */
class ViewHolderOneCol(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val listView = itemView.findViewById<ListView>(R.id.lv)
}

/**
 * 网格布局
 */
class ViewHolderTwoCol(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val item1 = itemView.findViewById<View>(R.id.item1)
    val item2 = itemView.findViewById<View>(R.id.item2)
    val item3 = itemView.findViewById<View>(R.id.item3)
    val item4 = itemView.findViewById<View>(R.id.item4)
}

/**
 * 个人信息布局
 */
class ViewHolderInfo(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivHead = itemView.findViewById<ShapeableImageView>(R.id.iv_head)
    val tvName = itemView.findViewById<TextView>(R.id.tv_name)
    val tvSignature = itemView.findViewById<TextView>(R.id.tv_signature)
    val ivMedal = itemView.findViewById<ImageView>(R.id.iv_medal)
}