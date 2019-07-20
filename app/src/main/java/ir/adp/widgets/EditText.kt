package ir.adp.widgets

import android.content.Context
import android.graphics.Typeface
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.util.AttributeSet
import ir.adp.formview.R


/**
 * Created by Ali on 6/3/2019.
 */

class EditText : TextInputLayout {

    val editText = TextInputEditText(context)

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
        editText.typeface = typeface
        editText.textSize = 14f
        addView(editText)
    }

    fun getText(): String {
        return editText.text.toString()
    }

    fun setText(text: String) {
        editText.setText(text)
    }
}