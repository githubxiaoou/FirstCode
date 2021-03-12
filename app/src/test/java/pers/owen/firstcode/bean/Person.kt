package pers.owen.firstcode.bean

open class Person(val name: String, val age: Int) {

    fun eat() {
        println("$name is eating. He is $age year old.")
    }
}