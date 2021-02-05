package pers.owen.firstcode

import org.junit.Test

class C09Test {

    @Test
    fun test() {
        // infix的用法
        if ("Hello Kotlin" beginsWith "Hello") {
            println("Success")
        }

        val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
        if (list has "Banana") {
            println("has Banana")
        }
    }
}