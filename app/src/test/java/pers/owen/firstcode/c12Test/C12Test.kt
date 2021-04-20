package pers.owen.firstcode.c12Test

import org.junit.Test

class C12Test {
    @Test
    fun test1() {
        val a = 10
        val b = 15
        val c = 5
        val larger = max(max(a, b), c)
    }

    @Test
    fun test2() {
        val a = 3.5
        val b = 3.8
        val c = 4.1
        val largest = max(a, b, c)
    }
}