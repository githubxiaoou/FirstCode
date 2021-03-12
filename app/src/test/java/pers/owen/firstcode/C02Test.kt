package pers.owen.firstcode

import org.junit.Test
import pers.owen.firstcode.bean.Person
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
        val s1 = Student()
        val s2 = Student("Jack", 19)
        val s3 = Student("a123", 5, "Jack", 19)
    }
}