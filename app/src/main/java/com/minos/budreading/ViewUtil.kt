package com.minos.budreading

import android.content.res.Resources
import android.util.TypedValue
import kotlin.math.roundToInt

object ViewUtil {
    fun dp2px(dpValue: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpValue,
            Resources.getSystem().displayMetrics
        ).roundToInt()
    }


}