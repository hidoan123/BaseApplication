package com.example.baseapplication.ultis

import android.net.Uri
import android.os.Build
import android.view.View
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.example.baseapplication.R
import java.io.File

fun ImageView?.loadImage(uri: Uri?) {
    if (uri == null || this == null) return
    Glide.with(this).load(uri).into(this)
}

//fun ImageView?.loadImage(string: String?) {
//    if (string == null || this == null) return
//    Glide.with(this).load(string)
//        .placeholder(
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) ResourcesCompat.getDrawable(
//                context.resources,
//                R.drawable.progress_anim,
//                context.theme
//            ) else null
//        )
//        .error(R.drawable.img_load_fail)
//        .into(this)
//}

fun ImageView?.loadImage(file: File?) {
    if (file == null || this == null) return
    Glide.with(this).load(file).into(this)
}
fun View?.gone() {
    if (this == null) return
    if (visibility != View.GONE) visibility = View.GONE
}

fun View?.visible() {
    if (this == null) return
    if (visibility != View.VISIBLE) visibility = View.VISIBLE
}

fun View?.invisible() {
    if (this == null) return
    if (visibility != View.INVISIBLE) visibility = View.INVISIBLE
}

inline fun View.hideIf(condition: () -> Boolean): View {
    if (visibility != View.INVISIBLE && condition()) {
        visibility = View.INVISIBLE
    }
    return this
}

inline fun View.goneIf(condition: () -> Boolean): View {
    if (visibility != View.GONE && condition()) {
        visibility = View.GONE
    }
    return this
}

inline fun View.hiddenIf(condition: () -> Boolean): View {
    visibility = if (condition()) {
        View.GONE
    } else {
        View.VISIBLE
    }
    return this
}
fun View?.setVisible(visible: Boolean) {
    this?.visibility = if (visible) View.VISIBLE else View.GONE
}