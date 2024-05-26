package com.minos.budreading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.minos.budreading.adapter.MineAdapter
import com.minos.budreading.model.CardBean
import com.minos.budreading.model.CardItemBean1
import com.minos.budreading.model.CardItemBean3
import com.minos.budreading.model.InfoModel

/**
 * 我
 */
class MineFragment : Fragment() {

    private lateinit var rv: RecyclerView
    private val mAdapter by lazy { MineAdapter(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mine, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = view.findViewById(R.id.rv)
        rv.adapter = mAdapter
        val dataList = mutableListOf(
            CardBean(type = 3, item3 = CardItemBean3("Minos", "平平淡淡", "https://avatars.githubusercontent.com/u/32434208?v=4", "")),
            CardBean(
                type = 1, item1 = CardItemBean1(
                    mutableListOf(InfoModel("账户", "", "ic_account"), InfoModel("付费会员卡", "", "ic_vip"))
                )
            ),
            CardBean(
                type = 1, item1 = CardItemBean1(
                    mutableListOf(
                        InfoModel("读书排行榜", "", "ic_rank"),
                        InfoModel("阅读时长", "", "ic_time"),
                        InfoModel("勋章", "", "ic_medal")
                    )
                )
            ),
            CardBean(type = 2),
            CardBean(
                type = 1, item1 = CardItemBean1(
                    mutableListOf(InfoModel("浏览记录", "", "ic_history"), InfoModel("关注", "", "ic_concern"))
                )
            ),
            CardBean(
                type = 1, item1 = CardItemBean1(
                    mutableListOf(InfoModel("上架萌芽读书", "", "ic_sell"))
                )
            ),
        )
        mAdapter.setData(dataList)
    }
}