package pers.owen.firstcode

import java.lang.StringBuilder
import kotlin.String

fun String.lettersCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

operator fun String.times(n: Int): String {
//    var builder = StringBuilder()
//    repeat(n){
//        builder.append(this)
//    }
//    return builder.toString()

    return repeat(n)
}