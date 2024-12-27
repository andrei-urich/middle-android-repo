package com.example.androidpracticumcustomview.ui.theme

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup

class CustomContainer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ViewGroup(context, attrs) {

    init {
        if (checkChildCount()) throw (IllegalStateException("ChildView amount exceed. Max is 2"))
        if (checkChildType()) throw (IllegalStateException("Incorrect childView's type. Must be a View-type only"))
        setWillNotDraw(false)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        require(MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        val count = childCount
        if (count != 0) {
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
        }
        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val childOne = getChildAt(0)
        if (childOne !== null && childOne.visibility != View.GONE) {
            val childWidth = childOne.measuredWidth
            val childHeight = childOne.measuredHeight
            val horizontalPadding = (this.measuredWidth - childWidth) / 2
            val left = horizontalPadding
            val top = this.measuredHeight / 2 - childHeight
            val right = horizontalPadding + childWidth
            val bottom = this.measuredHeight / 2
            childOne.layout(left, top, right, bottom)
            Log.d("MY", "$left, $top, $right, $bottom")
        }
        val childTwo = getChildAt(1)
        if (childTwo !== null && childTwo.visibility != View.GONE) {
            val childWidth = childOne.measuredWidth
            val childHeight = childOne.measuredHeight
            val horizontalPadding = (this.measuredWidth - childWidth) / 2
            val left = horizontalPadding
            val right = horizontalPadding + childWidth
            val top = this.measuredHeight / 2
            val bottom = this.measuredHeight / 2 + childHeight
            childTwo.layout(left, top, right, bottom)
            Log.d("MY", "$left, $top, $right, $bottom")
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val childOne = getChildAt(0)
        if (childOne !== null && childOne.visibility != View.GONE) {
            val endPositionOne = (-this.measuredHeight / 2 + childOne.measuredHeight).toFloat()
            childOne.alpha = 0F
            childOne.animate()
                .alpha(1F)
                .setDuration(1000)
                .translationY(endPositionOne)
                .setDuration(5000)
        }

        val childTwo = getChildAt(1)
        if (childTwo !== null && childOne.visibility != View.GONE) {
            val endPositionTwo = (this.measuredHeight / 2 - childTwo.measuredHeight).toFloat()
            childTwo.alpha = 0F
            childTwo.animate()
                .alpha(1f)
                .translationY(endPositionTwo)
                .setDuration(5000)
        }
    }

    private fun checkChildCount(): Boolean {
        val childCount = childCount
        if (childCount <= 2) return false else return true
    }

    private fun checkChildType(): Boolean {
        val childCount = childCount
        for (i in 0..childCount - 1) {
            val child = getChildAt(i)
            if (child !is View) return true
        }
        return false
    }
}