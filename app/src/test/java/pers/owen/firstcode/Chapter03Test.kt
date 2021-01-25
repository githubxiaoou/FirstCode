package pers.owen.firstcode

import org.junit.Test
import java.lang.StringBuilder

class Chapter03Test {

    /**
     * 标准函数的用法
     */
    @Test
    fun test(): Unit {
        val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
        // 普通写法
//        var builder = StringBuilder()
//        builder.append("Start eating fruits.\n")
//        for (fruit in list) {
//            builder.append(fruit).append("\n")
//        }
//        builder.append("Ate all fruits.")
//        var result = builder.toString()
//        println(result)

        // with和run函数返回的都是lambda表达式的最后一行代码的返回值
        // with写法:with函数的第一个参数就是整个lambda表达式的上下文
//        val result = with(StringBuilder()) {
//            append("Start eating fruits.\n")
//            for (fruit in list) {
//                append(fruit).append("\n")
//            }
//            append("Ate all fruits.")
//        }
//        println(result)

        // run写法：与with函数类似，只是写法上面的区别
//        val result = StringBuilder().run {
//            append("Start eating fruits.\n")
//            for (fruit in list) {
//                append(fruit).append("\n")
//            }
//            append("Ate all fruits.")
//        }
//        println(result)

        // apply函数写法：apply函数无法指定返回值，只能返回调用对象本身
        val result = StringBuilder().apply {
            append("Start earing fruits. \n")
            for (fruit in list) {
                append(fruit).append("\n")
            }
            append("Ate all fruits.")
        }
        println(result)

        // 实际使用场景见举例1

    }

    /**
     * 定义静态方法
     * 1、单例类
     * 2、companion object关键字+@JvmStatic注解
     * 3、顶层类
     */
    @Test
    fun staticMethodTest() {
        Util.doAction()
        Util2.doAction2()
        doSomething()// kotlin中可以在任意位置调用顶层方法，java中使用[文件名]kt.doSomething()的方式
    }
}