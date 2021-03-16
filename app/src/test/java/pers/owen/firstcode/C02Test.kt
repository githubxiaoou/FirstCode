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

    @Test
    fun test10() {
        val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
//        var maxLengthFruit = ""
//        for (fruit in list) {
//            if (fruit.length > maxLengthFruit.length) {
//                maxLengthFruit = fruit
//            }
//        }

        // list.maxBy()相当于遍历这个集合，传入的lambda便是过滤的条件
//        val lambda = {fruit: String -> fruit.length}
//        var maxLengthFruit = list.maxBy(lambda)

        // 简化开始
        // 1、将表达式传入maxBy函数当中
//        var maxLengthFruit = list.maxBy({ fruit: String -> fruit.length })

        // 2、Kotlin规定，当Lambda参数是函数的最后一个参数时，可以将Lambda表达式移到函数括号的外面
//        var maxLengthFruit = list.maxBy(){ fruit: String -> fruit.length }

        // 3、如果Lambda参数是函数的唯一一个参数的话，可以将函数的括号省略
//        var maxLengthFruit = list.maxBy{ fruit: String -> fruit.length }

        // 4、类型推导
//        var maxLengthFruit = list.maxBy{ fruit -> fruit.length }

        // 5、Lambda表达式的参数列表中只有一个参数时，不必声明参数名，而是使用it关键字代替
        var maxLengthFruit = list.maxBy { it.length }

//        var maxLengthFruit = list.maxBy { it.length }

        println("max length fruit is $maxLengthFruit")
    }

    @Test
    fun test11() {
        val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
        val newList = list.filter { it.length <= 5 }
            .map { it.toUpperCase() }
        for (fruit in newList) {
            println(fruit)
        }
    }

    @Test
    fun test12() {
        val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
        val anyResult = list.any { it.length <=5 }
        val allResult = list.all { it.length <=5 }
        println("anyResult is $anyResult, allResult is $allResult")
    }

    @Test
    fun test13() {
        Thread {
            println("Thread is running")
        }.start()
    }


    @Test
    fun test14() {
        doStudy(null)
    }


    private fun doStudy(study: Study?) {
        study?.readBooks()
        study?.doHomework()

//        if (study != null) {
//            study.readBooks()
//        }
//
//        if (study != null) {
//            study.doHomework()
//        }
//        study?.let {
//            it.readBooks()
//            it.doHomework()
//        }
    }


    /*当study为成员变量时的示例*/
    var study:Study? = null
    private fun doStudy() {
        if (study != null) {
//            study.readBooks()
//            study.doHomework()
        }
    }



    @Test
    fun test15() {
//        val c = if (a != null) {
//            a
//        } else {
//            b
//        }
//
//        val c = a ?: b

        val upperCase = "content!!.".toUpperCase()
        println(upperCase)
    }

    @Test
    fun test16() {
        val age = 18
        val stu = Student("Jack", age)
        println("The boy is named ${stu.name}, he is $age year old")
    }

    private fun printParams(num: Int, str: String = "hello", string: String = "csdn") {
        println("num is $num, str is $str, string is $string")
    }

    @Test
    fun test17() {
        printParams(string = "world", str = "lively", num = 3)
    }
}