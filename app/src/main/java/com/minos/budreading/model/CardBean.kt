package com.minos.budreading.model

data class CardBean(
    // 1-单列 2-双列 3-信息
    val type: Int,
    val item1: CardItemBean1? = null,
    val item2: CardItemBean2? = null,
    val item3: CardItemBean3? = null
)

data class CardItemBean1(
    val list: List<InfoModel> = mutableListOf()
)

data class CardItemBean2(
    val state: String?,
    val num: String?,
    val remain: String?,
    val description: String?
)

data class CardItemBean3(
    val name: String?,
    val signature: String?,
    val headUrl: String?,
    val medalUrl: String?
)