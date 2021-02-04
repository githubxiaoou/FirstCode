package pers.owen.firstcode

import android.content.SharedPreferences

fun SharedPreferences.open(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}