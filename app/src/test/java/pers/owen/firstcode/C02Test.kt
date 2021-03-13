package pers.owen.firstcode

import org.junit.Test
import pers.owen.firstcode.`interface`.Study
import pers.owen.firstcode.bean.Cellphone
import pers.owen.firstcode.bean.Person
import pers.owen.firstcode.bean.Singleton
import pers.owen.firstcode.bean.Student
import kotlin.math.max

class C02Test {
    @Test
    fun main() {
        println("csdn小瓯\n")
    }

    @Test
    fun test2() {
        val a = 10
//        a *= 10
        println("a = $a")
    }

    fun largeNum(num1: Int, num2: Int): Int = max(num1, num2)

    fun getScore(name: String) = when {
        name.startsWith("Tom") -> 86
        name.endsWith("Jim") -> 77
        name == "Jack" -> 95
        name == "Lily" -> 100
        else ->  0
    }

    @Test
    fun testFor() {
        for (i in 1..10) {
            print(i)
        }

        println()

        for (i in 0 until 10 step 2) {
            print(i)
        }

        println()

        for (i in 10 downTo 1) {
            print(i)
        }
    }

    @Test
    fun test3() {
//        val s1 = Student()
//        val s2 = Student("Jack", 19)
//        val s3 = Student("a123", 5, "Jack", 19)
    }


    @Test
    fun test4() {
        val student = Student("Jack", 19)
        doStudy(student)
    }

    private fun doStudy(study: Study) {
        study.readBooks()
        study.doHomework()
    }

    @Test
    fun test5() {
        val cellphone1 = Cellphone("Sansung", 1299.99)
        val cellphone2 = Cellphone("Sansung", 1299.99)
        println(cellphone1)
        println("cellphone1 equals cellphone2 " + (cellphone1 == cellphone2))
    }

    @Test
    fun test6() {
        Singleton.singletonTest()
    }

    @Test
    fun test7() {
//        val list = ArrayList<String>()
//        list.add("Apple")
//        list.add("Banana")
//        list.add("Orange")
//        list.add("Pear")
//        list.add("Grape")

//        val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")

        val list = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
        list.add("Watermelon")
        for (fruit in list) {
            println(fruit)
        }
    }

    @Test
    fun test8() {
        val list = mutableSetOf("Apple", "Banana", "Orange", "Pear", "Grape")
        list.add("Watermelon")
        for (fruit in list) {
            println(fruit)
        }
    }

    @Test
    fun test9() {
//        val map = HashMap<String, Int>()
//        map.put("Apple", 1)
//        map.put("Banana", 2)
//        map.put("Orange", 3)
//        map.put("Pear", 4)
//        map.put("Grape", 5)
//
//        // 添加或编辑
//        map["Apple"] = 10
//        // 读取
//        val num = map["Apple"]

        val map = mutableMapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)

        for ((fruit, number) in map) {
            println("fruit is $fruit, number is $number")
        }
    }
}