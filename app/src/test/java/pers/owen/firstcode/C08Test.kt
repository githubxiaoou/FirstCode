package pers.owen.firstcode

import android.content.UriMatcher
import android.system.Os.close
import android.util.Log
import org.junit.Test
import java.lang.StringBuilder
import kotlin.math.log

class C08Test {

//    /**
//     * 泛型类调用
//     */
//    @Test
//    fun test() {
//        val myClass = MyClass<Int>()
//        val result = myClass.method(123)
//    }


//    /**
//     * 泛型方法调用
//     */
//    @Test
//    fun test1() {
//        val myClass = MyClass()
//        val result = myClass.method<Int>(123)
//    }


    fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
        block()
        return this
    }


    // 定义成泛型
    fun <T> T.build(block: T.() -> Unit): T {
        block()
        return this
    }


    // 使用build函数简化Cursor的遍历
//    contentResolver.query(url, null, null, null, null)?.build{
//        while (moveToNext()) {
//            ...
//        }
//        close()
//    }


    /*测试自定义的later函数*/
    val uriMatcher by later {
        val matcher = UriMatcher(UriMatcher.NO_MATCH)
        matcher.addURI("","book",123)
        matcher.addURI("","book/#",234)
    }


}