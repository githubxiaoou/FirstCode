package pers.owen.firstcode.c12Test

import org.junit.Test
import kotlin.math.max

class C12Test {
    @Test
    fun test1() {
        val a = 10
        val b = 15
        val c = 5
        val larger = max(max(a, b), c)
    }


}