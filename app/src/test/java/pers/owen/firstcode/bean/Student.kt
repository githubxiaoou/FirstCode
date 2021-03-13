package pers.owen.firstcode.bean

import pers.owen.firstcode.`interface`.Study

//class Student(val sno: String, val grade: Int, name:String, age: Int): Person(name, age) {
//    init {
//        println("sno is $sno")
//        println("gradle is $grade")
//    }
//
//    constructor(name: String, age: Int) : this("", 0, name, age)
//
//    constructor():this("", 0)
//}

//class Student: Person {
//
//    constructor(name: String, age: Int) : super(name, age)
//
//}

class Student(name: String, age: Int) : Person(name, age), Study {
    override fun readBooks() {
        println("$name is reading.")
    }

//    override fun doHomework() {
//        println("$name is doing homework.")
//    }

}
