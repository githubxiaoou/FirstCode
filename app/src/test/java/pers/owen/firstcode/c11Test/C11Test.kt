package pers.owen.firstcode.c11Test

import kotlinx.coroutines.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import org.junit.Test
import java.io.IOException
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


fun test() {

}
class C11Test {


    @Test
    fun test1() {
        GlobalScope.launch {
            println("codes run in coroutines scope")
            delay(1500)
            println("codes run in coroutines scope finished")
        }
        Thread.sleep(1000)
    }

    @Test
    fun test2() {
        // 保证协程作用域内的所有代码和子协程没有全部执行完之前一直阻塞当前线程。
        // runBlocking函数通常只应该在测试环境使用。
        runBlocking {
            println("codes run in coroutines scope")
            delay(1500)
            println("codes run in coroutines scope finished")
        }
    }

    @Test
    fun test3() {
        runBlocking {
            // launch函数只有在协程的作用域中才能调用，它会在当前协程的作用域下创建协程。
            // 子协程的特点是如果外层作用域的协程结束了，该作用域下的所有子协程也会一同结束。
            launch {
                println("launch1")
                delay(1000)
                println("launch1 finish")
            }

            launch {
                println("launch2")
                delay(1000)
                println("launch2 finish")
            }
        }
    }

    @Test
    fun test4() {
        // 该方法用来测试协程的并发效率
        val start = System.currentTimeMillis()
        runBlocking {
            repeat(100000) {
                launch {
                    println(".")
                }
            }
        }
        var end = System.currentTimeMillis()
        println(end - start)
    }

    suspend fun printDot() {
        println(".")
        delay(1000)
    }

    suspend fun printDot2() = coroutineScope {
        launch {
            println(".")
            delay(1000)
        }
    }

    @Test
    fun test5() {
        runBlocking {
            // coroutineScope函数和runBlocking函数类似，可以保证其作用域内的所有代码和子协程在全部执行完之前，会一直阻塞当前协程。
            coroutineScope {
                launch {
                    for (i in 1..10) {
                        println(i)
                        delay(1000)
                    }
                }
            }
            println("coroutineScope finished")
        }
        println("runBlocking finished")
    }

    @Test
    fun test6() {
        val job = Job()
        val scope = CoroutineScope(job)
        scope.launch {

        }
        job.cancel()
    }

    @Test
    fun test7() {
        runBlocking {
            // 调用await()方法来获取async函数的执行结果
            val result = async {
                5 + 5
            }.await()
            println(result)
        }
    }

    @Test
    fun test8() {
        runBlocking {
            // 串行执行示例
            val start = System.currentTimeMillis()
            val result1 = async {
                delay(1000)
                5 + 5
            }.await()
            val result2 = async {
                delay(1000)
                4 + 6
            }.await()
            println("result is ${result1 + result2}")
            val end = System.currentTimeMillis()
            println("cost ${end - start} ms.")
        }
    }

    @Test
    fun test9() {
        runBlocking {
            val start = System.currentTimeMillis()
            val deferred1 = async {
                delay(1000)
                5 + 5
            }
            val deferred2 = async {
                delay(1000)
                4 + 6
            }
            println("result is ${deferred1.await() + deferred2.await()}")
            val end = System.currentTimeMillis()
            println("cost ${end - start} ms.")
        }
    }

    @Test
    fun test10() {
        runBlocking {
            // Dispatchers.Default: 低并发线程策略，如计算密集型任务
            // Dispatchers.IO: 高并发线程策略，如网络请求
            // Dispatchers.Main: 不会开启线程
            val result = withContext(context = Dispatchers.Default) {
                5 + 5
            }
            println(result)
        }
    }

    @Test
    fun test11() {
        runBlocking {
            // 待补充
        }
    }

//    suspend fun <T> Call.await(): T {
//        return suspendCoroutine { continuation ->
//            enqueue(object : Callback {
//                override fun onFailure(call: Call, e: IOException) {
//                    continuation.resumeWithException(e)
//                }
//
//                override fun onResponse(call: Call, response: Response) {
//                    val body = response.body
//                    if (body != null) {
//                        continuation.resume(body)
//                    } else {
//                        continuation.resumeWithException(RuntimeException("response body is null"))
//                    }
//                }
//
//            })
//        }
//    }
}