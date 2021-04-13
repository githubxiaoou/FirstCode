package pers.owen.firstcode

/*泛型类*/
//class MyClass<T> {
//    fun method(param: T): T {
//        return param
//    }
//}


/*泛型方法*/
class MyClass {
    fun <T> method(param: T): T {
        return param
    }

    fun <T : Number> method(param: T): T {
        return param
    }
}


