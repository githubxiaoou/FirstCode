package pers.owen.firstcode

import org.junit.Test
import pers.owen.firstcode.bean.News
import java.lang.StringBuilder

class Chapter05Test {

    private val two = 2

    @Test
    fun test() {
        // for，inner class, repeat, random
        InnerTest().test1()
    }

    @Test
    fun test2() {
        // 扩展函数
        println("asdfisdjfo".lettersCount())
    }

    @Test
    fun test3() {
        // 运算符重载，Kotlin允许我们重载的关键字多达十几个
        var money1 = Money(5)
        var money2 = Money(10)
        var money3 = money1 + money2
        println(money3.value)

        var money4 = money3 + 20
        println(money4.value)
    }

    @Test
    fun test4() {
        val str = "abc" * 4
        println(str)
        println(str * (1..20).random())
    }

    inner class InnerTest {

        @Test
        fun test1() {
            println(getNews())
            println()
        }

        private fun getNews(): List<News> {
            val newList = ArrayList<News>()
            for (i in 1..50) {
                val news = News("This is news title $i"
                    , getRandomLengthString("This is news content $i."))
                newList.add(news)
            }
            return newList
        }

        private fun getRandomLengthString(string: String): String {
            val n = (1..20).random()
            val builder = StringBuilder()
            repeat(two) {
                builder.append(string)
            }
            return builder.toString()
        }
    }
}