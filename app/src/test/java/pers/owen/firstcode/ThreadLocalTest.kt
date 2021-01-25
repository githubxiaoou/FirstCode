package pers.owen.firstcode

import org.junit.Test

class ThreadLocalTest {
    @Test
    private fun test() {
        // 创建本地线程（主线程）
        val threadLocal = object : ThreadLocal<String>(){
            // 重写初始化方法，默认返回null，如果ThreadLocalMap拿不到值再调用初始化方法
            override fun initialValue(): String? {
                return "午后奶茶"
            }
        }

        // 从ThreadLocalMap中获取String值，key是主线程
        println("主线程threadLocal：" + threadLocal.get())

        //--------------------------thread-0
        val thread = Thread(Runnable {
            // 从ThreadLocalMap中获取key：thread-0的值？没有，拿不到值再调用初始化方法
            val value1 = threadLocal.get()
            println("thread-0=$value1")

            // ThreadLocalMap存入：key:thread-0  value:"一加"
            threadLocal.set("一加")
            val value2 = threadLocal.get() // 可以get到了
            println("thread-0  set  >>> " + threadLocal.get()) // 一加

            // 使用完成建议remove()，避免大量无意义的内存占用
            threadLocal.remove()

        })
        thread.start()

        //--------------------------thread-1
        val thread2 = Thread(Runnable {
            // 从ThreadLocalMap中获取key：thread-1的值？没有，拿不到值再调用初始化方法
            val value1 = threadLocal.get()
            println("thread-1：${threadLocal.get()}") // 午后奶茶

            // ThreadLocalMap存入：key:thread-1  value:"孙长老"
            threadLocal.set("孙长老")
            val value2 = threadLocal.get() // 可以get到了
            println("thread-1  set  >>> " + threadLocal.get()) // 孙长老

            // 使用完成建议remove()，避免大量无意义的内存占用
            threadLocal.remove()

        })
        thread2.start()
    }
}