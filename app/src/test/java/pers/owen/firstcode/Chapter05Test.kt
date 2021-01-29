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