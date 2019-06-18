package ir.adp.widgets

import android.content.Context
import android.graphics.Typeface
import android.support.design.widget.TextInputEditText
import android.support.design.widget.TextInputLayout
import android.util.AttributeSet
import android.view.Gravity
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

    override fun setErrorEnabled(enabled: Boolean) {
        super.setErrorEnabled(enabled)

        if (!enabled) {
            return
        }

        try {
            val errorViewField = TextInputLayout::class.java.getDeclaredField("mErrorView")
            errorViewField.isAccessible = true
            val errorView = errorViewField.get(this) as TextView
            if (errorView != null) {
                errorView.gravity = Gravity.RIGHT
                val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
                params.gravity = Gravity.END
                errorView.layoutParams = params
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}