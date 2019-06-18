package ir.adp.widgets

import android.content.Context
import android.support.design.widget.TextInputLayout
import android.util.AttributeSet
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import ir.adp.formview.R


/**
 * Created by Ali on 6/3/2019.
 */

class FormView : LinearLayout {

    private var etList = listOf<TextInputLayout>()
    private var btList = listOf<Button>()
    var errorText = "is required"


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
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        etList = getAllEditTexts()
        btList = getAllButtons()
    }

    fun setOnSubmitClickListener(listener: () -> Unit) {
        btList.forEach {
            if (it.id == R.id.submit) {
                it.setOnClickListener {
                    var noError = true
                    etList.forEach { childE ->
                        if (childE.tag != "optional") {
                            val text = childE.editText?.text?.trim()
                            if (text.isNullOrEmpty()) {
                                val hint = childE.hint
                                childE.error = "$hint $errorText"
                                noError = false
                            } else {
                                childE.isErrorEnabled = false
                            }
                        }
                    }
                    if (noError) {
                        listener()
                        resetForm()
                    }
                }
            }
        }
    }

    private fun resetForm() {
        etList.forEach {
            it.editText?.setText("")
            it.isErrorEnabled = false
        }
    }

    private fun getAllEditTexts(): List<TextInputLayout> {
        val list = arrayListOf<TextInputLayout>()

        fun find(v: View, list: ArrayList<TextInputLayout>) {
            if (v is TextInputLayout)
                list.add(v)
            else if (v is ViewGroup) {
                for (i in 0 until v.childCount) {
                    find(v.getChildAt(i), list)
                }
            }
        }

        find(this, list)

        return list
    }

    private fun getAllButtons(): List<Button> {
        val list = arrayListOf<Button>()

        fun find(v: View, list: ArrayList<Button>) {
            if (v is Button)
                list.add(v)
            else if (v is ViewGroup) {
                for (i in 0 until v.childCount) {
                    find(v.getChildAt(i), list)
                }
            }
        }

        find(this, list)

        return list
    }

    fun onNavigationItemSelected(menu: Menu, listener: () -> Unit) {
        val item = menu.findItem(R.id.submit)
        item.setOnMenuItemClickListener {
            var noError = true
            etList.forEach { childE ->
                if (childE.tag != "optional") {
                    val text = childE.editText?.text?.trim()
                    if (text.isNullOrEmpty()) {
                        val hint = childE.hint
                        childE.error = "$hint $errorText"
                        noError = false
                    } else {
                        childE.isErrorEnabled = false
                    }
                }
            }
            if (noError) {
                listener()
                resetForm()
            }
            return@setOnMenuItemClickListener true
        }
    }

}