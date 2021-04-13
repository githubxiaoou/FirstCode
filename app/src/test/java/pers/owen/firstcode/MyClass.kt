package pers.owen.firstcode

import kotlin.reflect.KProperty

/*泛型类*/
//class MyClass<T> {
//    fun method(param: T): T {
//        return param
//    }
//}


///*泛型方法*/
//class MyClass {
//    fun <T> method(param: T): T {
//        return param
//    }
//
//    fun <T : Number> method(param: T): T {
//        return param
//    }
//}


/*委托功能举例*/
class MyClass {
    var p by Delegate()


}

class Delegate {
    var propValue : Any? = null
    operator fun getValue(myClass: MyClass, property: KProperty<*>): Any? {
        return propValue
    }

    operator fun setValue(myClass: MyClass, property: KProperty<*>, any: Any?) {
        this.propValue = any
    }

}


