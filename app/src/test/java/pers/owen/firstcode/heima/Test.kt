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
        var s1: Son = Son.lv()
        var s2: Son = Son.ma()
        var s3: Son = Son.lv()

        var list = listOf<Son>(s1, s2, s3)

        for (son in list) {
            if (son is Son.lv) {
                son.sayHello()
            }
        }

    }
}