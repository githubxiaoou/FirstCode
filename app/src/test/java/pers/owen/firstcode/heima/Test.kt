package pers.owen.firstcode.heima

import org.junit.Test

class Test {
    @Test
    fun test1() {
        var lists = listOf<String>("买鸡蛋", "买大米", "买杜蕾斯", "买冰淇淋")
        for ((i, e) in lists.withIndex()) {
            println("$i   $e")
        }
    }

    @Test
    fun test2() {

    }
}