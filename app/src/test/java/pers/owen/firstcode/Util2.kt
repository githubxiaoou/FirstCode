package pers.owen.firstcode

fun doSomething() {
    println("doSomething")
}

class Util2 {
    fun doAction1() {
        println("doAction1")
    }

    companion object {
        // 不加注解其实调用伴生对象的doAction2方法，加上注解才是真正意义上的静态方法
        @JvmStatic
        fun doAction2() {
            println("doAction2")
        }
    }
}