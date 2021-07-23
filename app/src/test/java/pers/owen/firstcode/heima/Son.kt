package pers.owen.firstcode.heima

sealed class Son() {
    class lv : Son()
    class ma : Son()

    fun sayHello() {
        println("大家好！")
    }
}
