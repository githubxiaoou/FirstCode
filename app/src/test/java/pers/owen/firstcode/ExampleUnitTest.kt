package pers.owen.firstcode

import org.junit.Test

import org.junit.Assert.*
import pers.owen.firstcode.`interface`.Study

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        //        assertEquals(4, 2 + 2)
        val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")

        // 基本写法
//        var maxLengthFruit = ""
//        for (fruit in list) {
//            if (fruit.length > maxLengthFruit.length) {
//                maxLengthFruit = fruit
//            }
//        }

        // lambda表达式写法
//        var lambda = {fruit : String -> fruit.length}
//        val maxLengthFruit = list.maxBy {it.length}
//
//        print("max length fruit is $maxLengthFruit")
//
//        // 转大写
//        var upList = list.map { it.toUpperCase() }
//        for (fruit in upList) {
//            println(fruit)
//        }
//
//        // filter函数的试用
//        val newList = list.filter { it.length <= 5 }
//            .map { it.toLowerCase() }
//        for (fruit in newList) {
//            println(fruit)
//        }

        // any和all的用法
//        val anyResult = list.any { it.length <= 5 }
//        val allResult = list.all { it.length <= 5 }
//        println("anyResult is $anyResult, allResult is $allResult")
    }

    @Test
    fun javaApiTest() {
        // 必须是Java单抽象方法接口参数
        Thread(Runnable {
            println("Thread is running!")
        }).start()
    }

    @Test
    fun nullPointTest() {
//        doStudy(null)
//
//        println(getTextLength(null))
//        printUpperCase()

        printParams(str = "sdf")
    }

    /*?:*/
    private fun getTextLength(text: String?) = text?.length ?: 0

    /*?. , let*/
    private fun doStudy(study: Study?) {
        study?.readBooks()
        study?.doHomework()

        study?.let {
            it.readBooks()
            it.doHomework()
        }
    }

    /*!!*/
    private var content : String ? = "111"
    fun printUpperCase() {
        val upperCase = content!!.toUpperCase()
        println(upperCase)
    }

    /*函数的参数默认值*/
    private fun printParams(num: Int = 100, str: String) {
        println("num is $num , str is $str")
    }


}