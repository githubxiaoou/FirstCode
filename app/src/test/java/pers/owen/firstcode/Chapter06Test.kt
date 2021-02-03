package pers.owen.firstcode

import org.junit.Test
import java.lang.StringBuilder

class Chapter06Test {

    @Test
    fun test() {
        // 高阶函数
        val num1 = 100
        val num2 = 80
        val result1 = num1AndNum2(num1, num2, ::plus)
        val result2 = num1AndNum2(num1, num2, ::minus)
        println("result1 is $result1")
        println("result2 is $result2")
        val result3 = num1AndNum2(num1, num2){num1, num2 -> num1 + num2}
        val result4 = num1AndNum2(num1, num2){num1, num2 -> num1 - num2}
        println("result3 is $result3")
        println("result4 is $result4")

        // 完整语法规则，在函数类型前面加上ClassName.就表示这个函数类型是定义在哪个类当中
        // 好处就是这样就自动拥有了该类的上下文
        val list = listOf("apple", "Banana", "Orange", "pear", "Grape")
        val result = StringBuilder().build {
            append("Start eating fruit.\n")
            for (fruit in list) {
                append(fruit).append("\n")
            }
            append("Ate all fruits.")
        }
        println(result.toString())
    }

    private fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
        return operation(num1, num2)
    }

    fun plus(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun minus(num1: Int, num2: Int): Int {
        return num1 - num2
    }

    private fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
        block()
        return this
    }

    @Test
    fun test2() {
        // 内联函数inline，kotlin编译器会内联函数中的代码在编译的时候自动替换调用它的地方
        val num1 = 30
        val num2 = 40
        var result = numAndNum(num1, num2) { num1, num2 ->
            num1 + num2
        }
        println("result is $result")

        // 最终的替换结果
        result = num1 + num2
        println("result is $result")
    }

    inline fun numAndNum(num1: Int, num2: Int, operation: (Int, Int) -> Int) : Int {
        return operation(num1, num2)
    }

    @Test
    fun test3() {
        // noinline
        println("main begin")
        val str = "d"
        printString(str) {
            s ->
            println("Lambda begin")
            if (s.isEmpty()) return
            println(s)
            println("Lambda begin")
        }
        println("main end")
    }

    // inline是默认内联所有lambda表达式，加了noinline标识来排序内联
    /**
     * Lambda表达式不能直接用return关键字，除非这个Lambda表达式是内联函数的参数。
     * inline会导致函数类型的参数无法被当做对象被使用，这个时候就有了noinline。
     * 内联函数类型的参数不允许间接调用，除非有crossinline的修饰，但是如果加了这个修饰，则也就承诺了Lambda表达式中不会有return。
     */
    inline fun inlineTest(block1: () -> Unit, noinline block2: () -> Unit) {

    }

    private inline fun printString(str: String, block: (String) -> Unit) {
        println("printString begin")
        block(str)
        println("printString end")
    }

    @Test
    fun test04() {
        //crossinline
        hello {
            println("Bye")
//            return
        }
    }

    private inline fun hello(crossinline postAction: () -> Unit) {
        println("Hello!")
        val runnable = Runnable{
            postAction()
        }
        runnable.run()
    }
}