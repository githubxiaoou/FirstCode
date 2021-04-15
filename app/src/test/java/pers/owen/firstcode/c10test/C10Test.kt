package pers.owen.firstcode.c10test

import org.junit.Test

class C10Test {

    inline fun <reified T> getGenericType() = T::class.java

    @Test
    fun test01() {
        val result1 = getGenericType<String>()
        val result2 = getGenericType<Int>()
        println("result1 is $result1")
        println("result2 is $result2")
    }


    @Test
    fun test03() {
        val student = Student("Tom", 19)
        var data = SimpleData<Student>(student)
        handleSimpleData(data = data)
        val get = data.get()
    }

    fun handleSimpleData(data: SimpleData<Person>) {
        val get = data.get()
    }

    interface MyClass<T> {
        fun method(param: T): T
    }

    @Test
    fun test04() {
        val trans = object : Transformer<Person> {
            override fun transformer(t: Person): String {
                return "${t.name} ${t.age}"
            }
        }
        handleTransformer(trans = trans) // 这行会报错
    }

    fun handleTransformer(trans: Transformer<Student>) {
        var student = Student("Tom", 19)
        var result = trans.transformer(student)
    }

}