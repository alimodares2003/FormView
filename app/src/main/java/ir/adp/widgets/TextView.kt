package ir.adp.widgets

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView
import ir.adp.formview.R

/**
 * Created by Ali on 6/3/2019.
 */

class TextView : TextView {
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView()
    }

    constructor(context: Context) : super(context) {
        initView()
    }

    private fun initView() {
        val typeface = Typeface.createFromAsset(context.assets, context.getString(R.string.font_mainRegular))
        setTypeface(typeface)
    }
}