package pers.owen.firstcode.c10test

//class SimpleData<T> {
//    private var data: T? = null
//
//    fun set(t: T?) {
//        data = t
//    }
//
//    fun get(): T? {
//        return data
//    }
//}

class SimpleData<out T>(val data: T?) {
    fun get(): T? {
        return data
    }
}