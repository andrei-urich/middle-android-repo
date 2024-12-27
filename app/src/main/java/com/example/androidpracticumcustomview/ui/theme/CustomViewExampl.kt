package com.example.androidpracticumcustomview.ui.theme

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup

class CustomViewExampl @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ViewGroup(context, attrs) {

    init {
        if (!checkChildCount()) error(IllegalStateException("Child amount exceed"))
        setWillNotDraw(false)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        require(MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED)

        val width = MeasureSpec.getSize(widthMeasureSpec)
        var height = MeasureSpec.getSize(heightMeasureSpec)
        val count = childCount
        val childHeightMeasureSpec =
            if (MeasureSpec.getMode(heightMeasureSpec) == MeasureSpec.AT_MOST) {
                MeasureSpec.makeMeasureSpec(height, MeasureSpec.AT_MOST)
            } else {
                MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
            }

        for (i in 0 until count) {
            val child = getChildAt(i)
            if (child.visibility != View.GONE) {
                child.measure(
                    MeasureSpec.makeMeasureSpec(width, MeasureSpec.AT_MOST),
                    childHeightMeasureSpec
                )
            }
        }
        setMeasuredDimension(width, height)
        Log.d("MY", "onMesure() set $width $height")
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        val childOne = getChildAt(0)
        if (childOne !== null && childOne.visibility != View.GONE) {
            val childw = childOne.measuredWidth
            val childh = childOne.measuredHeight
            val left = 0
            val top = 0
            val right = childw
            val bottom = childh
            childOne.layout(left, top, right, bottom)
            Log.d("MY", "$left, $top, $right, $bottom")
        }
        val childTwo = getChildAt(1)
        if (childTwo !== null && childTwo.visibility != View.GONE) {
            val childw = childOne.measuredWidth
            val childh = childOne.measuredHeight
            val left = 0
            val top = this.measuredHeight-childh
            val right = childw
            val bottom = this.measuredHeight
            childTwo.layout(left, top, right, bottom)
            Log.d("MY", "$left, $top, $right, $bottom")
        }
    }
    private fun checkChildCount(): Boolean {
        val childCount = getChildCount()
        return childCount <= 2
    }
}

