package com.azer.azexpressandroid.utils

import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("fontText")
fun setFont(view: View, fontName: String?) {
    if (fontName != null) {
        val typeface: Typeface? = Typeface.createFromAsset(view.context.assets, "fonts/${fontName}")
        when (view) {
            is EditText -> {
                view.typeface = typeface
            }
            is TextView -> {
                view.typeface = typeface
            }
            is TextInputLayout -> {
                view.typeface = typeface
            }
            is AppCompatTextView -> {
                view.typeface = typeface
            }
            is AppCompatEditText -> {
                view.typeface = typeface
            }
            is Button -> {
                view.typeface = typeface
            }
            is AppCompatButton -> {
                view.typeface = typeface
            }
            is ViewGroup -> {
                for (i in 0 until view.childCount) setFont(
                    view.getChildAt(
                        i
                    ), fontName
                )
            }
        }
    }
}

@BindingAdapter("spacing")
fun setSpacing(view: View, spacing: Float?) {
    if (spacing != null) {
        when (view) {
            is EditText -> {
                view.letterSpacing = spacing
            }
            is TextView -> {
                view.letterSpacing = spacing
            }
            is AppCompatTextView -> {
                view.letterSpacing = spacing
            }
            is AppCompatEditText -> {
                view.letterSpacing = spacing
            }
            is Button -> {
                view.letterSpacing = spacing
            }
            is AppCompatButton -> {
                view.letterSpacing = spacing
            }
            is ViewGroup -> {
                for (i in 0 until view.childCount) setSpacing(
                    view.getChildAt(
                        i
                    ), spacing
                )
            }
        }
    }
}